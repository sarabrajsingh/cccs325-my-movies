package com.example.mymovies.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mymovies.MainActivity;
import com.example.mymovies.adapters.MovieListFragmentAdapter;
import com.example.mymovies.data.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MovieListFragment extends ListFragment {

    // Interface for data sharing
    public interface MovieListListener {
        void itemClicked(String movieName);
    }

    // class instance of listener
    private MovieListListener listener;
    private MovieListFragmentAdapter adapter;
    View previous;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "filter";

    private String mParam1;
    private ArrayList<String> movieNames;
    private String[] array;

    public MovieListFragment() {
        // Required empty public constructor
    }

    // newInstance helper
    public static MovieListFragment newInstance(String param1) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        previous = new View(getContext());
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity = new Activity();
        if(context instanceof Activity){
            activity = (Activity) context;
        }
        this.listener = (MovieListListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // extract movies from the LinkedListHashMap in the Movie class using an Iterator
        Iterator<Map.Entry<String, Movie>> lhmIterator = Movie.movies.entrySet().iterator();

        // using ArrayList because we have no idea what the number of return movies from the filter will be
        movieNames = new ArrayList<String>();

        if(mParam1 != null){
            while(lhmIterator.hasNext()){
                Map.Entry<String, Movie> mapElement = lhmIterator.next();
                String[] tags = ((Movie)mapElement.getValue()).getTags();
                if(Arrays.asList(tags).contains(mParam1)){
                    movieNames.add((String)mapElement.getKey());
                }
            }
            // pass first movie in new list to static instance of MainActivity
        } else {
            while (lhmIterator.hasNext()) {
                Map.Entry<String, Movie> mapElement = lhmIterator.next();
                movieNames.add(mapElement.getKey());
            }

        }
        // pass first movie in new list to static instance of MainActivity
        MainActivity.currentMovieSelection = movieNames.get(0);

        // convert arrayList to array for the ListAdapter :(
        array = new String[movieNames.size()];
        for(int j = 0; j < movieNames.size(); j++){
            array[j] = movieNames.get(j);
        }

        // custom List Adapter implementation
        this.adapter = new MovieListFragmentAdapter(getContext(), array);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // itemClicked() is inherited from the interface
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        if(listener != null){
            previous.setSelected(false);
            v.setSelected(true);
            previous = v;
            listener.itemClicked(movieNames.get((int)id));
        }
    }
}