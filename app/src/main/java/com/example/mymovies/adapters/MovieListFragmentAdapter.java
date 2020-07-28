package com.example.mymovies.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mymovies.R;

public class MovieListFragmentAdapter extends BaseAdapter {

    Context context;
    private final String[] item_values;

    public MovieListFragmentAdapter(Context context, String[] item_values){
        this.context = context;
        this.item_values = item_values;
    }

    @Override
    public int getCount() {
        return item_values.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.fragment_list_movie_list, parent, false);

            viewHolder.textView = (TextView)convertView.findViewById(R.id.movie_list_item);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        if(item_values[position] != null){
            viewHolder.textView.setText(item_values[position]);
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
