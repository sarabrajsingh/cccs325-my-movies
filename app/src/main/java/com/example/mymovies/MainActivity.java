package com.example.mymovies;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mymovies.adapters.SectionsPagerAdapter;
import com.example.mymovies.fragments.MovieListFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements MovieListFragment.MovieListListener {

    public static String currentMovieSelection = null;
    private ViewPager viewPager;
    TabLayout tabs;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager adapter and instantiation
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        this.viewPager = findViewById(R.id.view_pager);
        this.viewPager.setAdapter(sectionsPagerAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        regenerateMovieListFragment(null);

        // activate menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    // react from clicks done in the MovieListFragment
    @Override
    public void itemClicked(String movieName) {
        MainActivity.currentMovieSelection = movieName;
        Objects.requireNonNull(this.viewPager.getAdapter()).notifyDataSetChanged();
    }

    // inflate menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // react from menu item cliks
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        regenerateMovieListFragment(menuItem.getTitle().toString());
        return super.onOptionsItemSelected(menuItem);
    }
    // helper function to re-generate MovieListFragment with an argument
    private void regenerateMovieListFragment(String filter){
        MovieListFragment movieListFragment;
        movieListFragment = (filter != null) ? MovieListFragment.newInstance(filter) : MovieListFragment.newInstance(null);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame_layout, movieListFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
    // trying to handle back button; rudimentary; basically reset the view
    @Override
    public void onBackPressed(){
        regenerateMovieListFragment(null);
    }
}