package com.example.mymovies.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mymovies.MainActivity;
import com.example.mymovies.R;
import com.example.mymovies.fragments.Description;
import com.example.mymovies.fragments.Poster;
import com.example.mymovies.fragments.Trailer;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    // constructor
    public SectionsPagerAdapter(Context mContext, FragmentManager fm){
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public int getItemPosition(Object object) {
        // POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_NONE;
    }

    // main tab work done here
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a Fragment (defined in Poster, Description and Trailer classes)
        switch(position){
            case 0:
                return Poster.newInstance(MainActivity.currentMovieSelection);
            case 1:
                return Description.newInstance(MainActivity.currentMovieSelection);
            case 2:
                return Trailer.newInstance(MainActivity.currentMovieSelection);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return SectionsPagerAdapter.TAB_TITLES.length;
    }
}
