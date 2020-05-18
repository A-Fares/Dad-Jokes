package com.example.dadjokes.main.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dadjokes.data.JokeClient;
import com.example.dadjokes.pojo.JokeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokeViewModel extends ViewModel {
    MutableLiveData<JokeModel> JokeMutableLiveData = new MutableLiveData<>();

    public void getJoke() {
        JokeClient.getINSTANCE().getJoke().enqueue(new Callback<JokeModel>() {
            @Override
            public void onResponse(Call<JokeModel> call, Response<JokeModel> response) {
                JokeMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JokeModel> call, Throwable t) {

            }
        });
    }
}
