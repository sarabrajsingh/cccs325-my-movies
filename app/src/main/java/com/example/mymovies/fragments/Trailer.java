package com.example.mymovies.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mymovies.MainActivity;
import com.example.mymovies.R;
import com.example.mymovies.data.Movie;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class Trailer extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String API_KEY = "AIzaSyDDY1vXd7b4GCMpzLyK1i13o7ueb5zb7RI";
    private YouTubePlayer yt;

    private int mParam1;

    public Trailer() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Trailer newInstance(String param1) {
        Trailer fragment = new Trailer();
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
        View view = inflater.inflate(R.layout.fragment_trailer, container, false);

        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.youtube_container, youTubePlayerSupportFragment).commit();

        youTubePlayerSupportFragment.initialize(Trailer.API_KEY, new YouTubePlayer.OnInitializedListener() {

            // get movie short url
            Movie movie = (Movie)Movie.movies.get(MainActivity.currentMovieSelection);
            String movieHash = movie.getApiKey();
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                    yt = youTubePlayer;
                    yt.loadVideo(movieHash);
                    yt.play();
                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast toast = Toast.makeText(getContext(), youTubeInitializationResult.toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
    }
}