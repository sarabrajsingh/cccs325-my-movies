package com.example.mymovies.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymovies.MainActivity;
import com.example.mymovies.R;
import com.example.mymovies.data.Movie;

import java.util.Objects;

public class Description extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private TextView title;
    private TextView director;
    private TextView description;
    private TextView stars;

    private int mParam1;

    public Description() {
        // Required empty public constructor
    }

    public static Description newInstance(String param1) {
        Description fragment = new Description();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        this.title = view.findViewById(R.id.fragment_description_title_textview);
        this.description = view.findViewById(R.id.fragment_description_description_textview);
        this.director = view.findViewById(R.id.fragment_description_director_textview);
        this.stars = view.findViewById(R.id.fragment_description_stars_textview);

        if(getArguments() != null) {
            // reference to private helper method
            updateMyViews(Objects.requireNonNull(MainActivity.currentMovieSelection));
        }
        return view;
    }

    // helper methods
    private String flattenStarsStringArray(String[] stars){
        StringBuilder sb = new StringBuilder();
        sb.append("Stars: ");
        for(int i = 0; i < stars.length; i++){
            sb.append(stars[i]);
            if(!(i == stars.length-1)){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private void updateMyViews(String movieTitle){

        Movie movie = Movie.movies.get(movieTitle);

        this.title.setText(movieTitle);
        if(movie != null){
            this.description.setText(movie.getDescription());
            this.director.setText(movie.getDirector());
            this.stars.setText(flattenStarsStringArray(movie.getStars()));
        }
    }
}