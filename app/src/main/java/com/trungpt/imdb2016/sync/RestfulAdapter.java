package com.trungpt.imdb2016.sync;

import com.squareup.okhttp.OkHttpClient;
import com.trungpt.imdb2016.utils.Constant;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by Trung on 7/22/2015.
 */
public class RestfulAdapter
{
    private static RestAdapter restAdapter;

    public static RestAdapter getRestAdapter()
    {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(6000, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(6000, TimeUnit.SECONDS);
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constant.BASE_URL)
                .setClient(new OkClient(okHttpClient))
                .build();
        return restAdapter;
    }
}
