package com.trungpt.imdb2016.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.trungpt.imdb2016.R;
import com.trungpt.imdb2016.adapter.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trungpt on 01/02/2016.
 */
public class GridAdapter extends BaseAdapter
{
    private Context mContext;
    private List<Movie> movies = new ArrayList<>();

    // Constructor
    public GridAdapter(Context c, List<Movie> movies)
    {
        mContext = c;
        this.movies = movies;
    }

    public int getCount()
    {
        return movies.size();
    }

    public Object getItem(int position)
    {
        return movies.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        final Movie movie = movies.get(position);
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        if (convertView != null)
        {
            holder = (ViewHolder) convertView.getTag();
        }
        else
        {
            convertView = inflater.inflate(R.layout.movie_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.tvTitle.setText(movie.getTitle());
        Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Glide.with(mContext)
                .load(movie.getUrlPoster())
                .centerCrop()
                .override(width / 3, height / 4)
                .placeholder(R.drawable.thumbnail)
                .crossFade()
                .into(holder.ivAvatar);
        return convertView;
    }

    static class ViewHolder
    {
        @Bind(R.id.tvTitle)
        TextView tvTitle;
        @Bind(R.id.ivThumbnail)
        ImageView ivAvatar;

        public ViewHolder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}