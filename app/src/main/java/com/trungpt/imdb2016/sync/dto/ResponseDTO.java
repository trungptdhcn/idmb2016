package com.trungpt.imdb2016.sync.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trungpt on 02/02/2016.
 */
public class ResponseDTO
{
    @SerializedName("page")
    private int page;
    @SerializedName("total_result")
    private int totalResult;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<MovieDTO> movieDTOs;

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getTotalResult()
    {
        return totalResult;
    }

    public void setTotalResult(int totalResult)
    {
        this.totalResult = totalResult;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public List<MovieDTO> getMovieDTOs()
    {
        return movieDTOs;
    }

    public void setMovieDTOs(List<MovieDTO> movieDTOs)
    {
        this.movieDTOs = movieDTOs;
    }
}
