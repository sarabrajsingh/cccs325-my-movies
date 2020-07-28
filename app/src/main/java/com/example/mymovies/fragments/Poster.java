package com.example.mymovies.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mymovies.MainActivity;
import com.example.mymovies.R;
import com.example.mymovies.data.Movie;

import java.util.Objects;

public class Poster extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int mParam1;

    private ImageView imageView;

    public Poster() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Poster newInstance(String param1) {
        Poster fragment = new Poster();
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
        View view = inflater.inflate(R.layout.fragment_poster, container, false);
        this.imageView = view.findViewById(R.id.fragment_poster_imageview);

        if(getArguments() != null){
            updateMyViews((Movie)Objects.requireNonNull(Movie.movies.get(MainActivity.currentMovieSelection)));
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(Poster.ARG_PARAM1, MainActivity.currentMovieSelection);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    // helper method
    private void updateMyViews(Movie movie){
        this.imageView.setImageResource(movie.getImageId());
    }
}