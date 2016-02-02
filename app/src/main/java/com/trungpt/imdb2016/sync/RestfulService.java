package com.trungpt.imdb2016.sync;


import com.trungpt.imdb2016.utils.Constant;

/**
 * Created by Trung on 7/22/2015.
 */
public class RestfulService
{
    private static RestfulServiceIn restfulServiceIn;

    public static RestfulServiceIn getInstance()
    {
        restfulServiceIn = RestfulAdapter.getRestAdapter().create(RestfulServiceIn.class);
        return restfulServiceIn;
    }
}
