package com.example.dadjokes.data;

import com.example.dadjokes.pojo.JokeModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeInterface {
    @GET("Any")
    public Call<JokeModel> getJoke();
}
