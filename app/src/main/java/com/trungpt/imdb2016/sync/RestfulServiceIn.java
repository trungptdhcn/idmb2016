package com.trungpt.imdb2016.sync;

import com.trungpt.imdb2016.sync.dto.MovieDTO;
import com.trungpt.imdb2016.sync.dto.ResponseDTO;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Trung on 5/30/2015.
 */
public interface RestfulServiceIn
{
//
//
//    @Headers({
//            "Accept: application/vnd.vimeo.*+json; version=3.2",
//            "Authorization: bearer 32b89491aaa8dd01957ead8d2181848a"
//    })
//    @GET("/channels/{channel_id}/videos")
//    public VimeoResponseDTO getVideosByUser(@Path("channel_id") String category, @Query("per_page") int perpage, @Query("page") String page);


//    @Headers({
//            "Accept: application/vnd.vimeo.*+json; version=3.2",
//            "Authorization: bearer 32b89491aaa8dd01957ead8d2181848a"
//    })
//    @GET("/videos/{video_id}")
//    public VimeoDTO getVideoById(@Path("video_id") String video_id);

    //    @GET("/videos")
//    public DailymotionDTO getMostPopularVideoDailymotion(@Query("fields") String fields
//            , @Query("flags") String flags, @Query("sort") String sort
//            , @Query("page") Long page, @Query("limit") Long limit);
//    @GET("/channel/{id}/videos")
//    public DailymotionDTO getVideosOfChannel(@Path("id") String id
//            , @Query("fields") String fields
//            , @Query("sort") String sort
//            , @Query("page") Long page
//            , @Query("limit") Long limit);
//
    @GET("/3/movie/popular")
    public ResponseDTO getPopularMovie(@Query("api_key") String apiKey, @Query("page") int page);

}
