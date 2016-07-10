package io.appflate.droidvmp.androidsample.domain;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andrzejchm on 10/07/16.
 */

public enum ApiManager {
    INSTANCE;

    private static final String BASE_URL = "https://api.github.com/";
    private GithubApi api;

    ApiManager() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                  .addConverterFactory(
                                                      GsonConverterFactory.create())
                                                  .build();

        api = retrofit.create(GithubApi.class);
    }

    public GithubApi getApiService() {
        return api;
    }

    public static ApiManager getInstance() {
        return INSTANCE;
    }
}
