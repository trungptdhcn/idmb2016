package com.trungpt.imdb2016;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Bind;
import com.trungpt.imdb2016.adapter.GridAdapter;
import com.trungpt.imdb2016.adapter.model.Movie;
import com.trungpt.imdb2016.base.BaseActivity;
import com.trungpt.imdb2016.sync.RestfulService;
import com.trungpt.imdb2016.sync.dto.MovieDTO;
import com.trungpt.imdb2016.sync.dto.ResponseDTO;
import com.trungpt.imdb2016.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity
{
    GridAdapter adapter;
    @Bind(R.id.gridview)
    GridView gridview;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    protected DrawerLayout drawerLayout;
    protected ActionBarDrawerToggle drawerToggle;

    @Override
    public void setDataToView(Bundle savedInstanceState)
    {
        setupNavDrawer();
        if (drawerToggle != null)
        {
            drawerToggle.syncState();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new AsyncTask<List<Movie>, Void, List<Movie>>()
        {
            @Override
            protected List<Movie> doInBackground(List<Movie>... params)
            {
                ResponseDTO responseDTO = RestfulService.getInstance()
                        .getPopularMovie(Constant.API_KEY, 1);
                List<MovieDTO> movieDTOs = responseDTO.getMovieDTOs();
                List<Movie> movies = new ArrayList<Movie>();
                for (MovieDTO movieDTO : movieDTOs)
                {
                    movies.add(Movie.convertFromMovieDTO(movieDTO));
                }
                return movies;
            }

            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(List<Movie> movies)
            {
                super.onPostExecute(movies);
                adapter = new GridAdapter(MainActivity.this, movies);
                gridview.setAdapter(adapter);
            }
        }.execute();
    }

    @Override
    public int getLayout()
    {
        return R.layout.activity_main;
    }

    private void setupNavDrawer()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout == null || !isVisibleNav())
        {
            return;
        }
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, getActionBarToolbar(), R.string.drawer_open, R.string.drawer_close)
        {

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return false;
        }
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
