package com.example.dadjokes.data;

import com.example.dadjokes.pojo.JokeModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeClient {
    private static final String BASE_URL = "https://sv443.net/jokeapi/v2/joke/";
    private static JokeClient INSTANCE;
    private JokeInterface jokeInterface;

    public JokeClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jokeInterface = retrofit.create(JokeInterface.class);
    }

    public static JokeClient getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new JokeClient();
        return INSTANCE;
    }
public Call<JokeModel> getJoke(){
        return jokeInterface.getJoke();
}
}
