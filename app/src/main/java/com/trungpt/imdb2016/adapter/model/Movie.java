package com.trungpt.imdb2016.adapter.model;

import com.trungpt.imdb2016.sync.dto.MovieDTO;
import com.trungpt.imdb2016.utils.Constant;

/**
 * Created by trungpt on 02/02/2016.
 */
public class Movie
{
    private String title;
    private String overview;
    private String urlPoster;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getOverview()
    {
        return overview;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public String getUrlPoster()
    {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster)
    {
        this.urlPoster = urlPoster;
    }

    public static Movie convertFromMovieDTO(MovieDTO movieDTO)
    {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setOverview(movieDTO.getOverview());
        movie.setUrlPoster(Constant.BASE_IMAGE_URL + movieDTO.getPosterPath());
        return movie;
    }
}
