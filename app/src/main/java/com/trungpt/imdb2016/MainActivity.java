package com.trungpt.imdb2016;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import com.trungpt.imdb2016.adapter.GridAdapter;
import com.trungpt.imdb2016.adapter.model.Movie;
import com.trungpt.imdb2016.sync.RestfulService;
import com.trungpt.imdb2016.sync.dto.MovieDTO;
import com.trungpt.imdb2016.sync.dto.ResponseDTO;
import com.trungpt.imdb2016.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    GridAdapter adapter;
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        gridview = (GridView) findViewById(R.id.gridview);
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
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
