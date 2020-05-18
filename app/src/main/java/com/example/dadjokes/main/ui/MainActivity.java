package com.example.dadjokes.main.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dadjokes.R;
import com.example.dadjokes.pojo.JokeModel;

public class MainActivity extends AppCompatActivity {
    JokeViewModel jokeViewModel;
    TextView setupTV, deliveryTV;
    Button buttonJoke;
    String jokeType, setupJoke, deliveryJoke, joke;
    private View welcomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //VIEWS
        setupTV = findViewById(R.id.setupTV);
        deliveryTV = findViewById(R.id.deliveryTV);
        welcomeLayout = findViewById(R.id.welcome_layout);
        buttonJoke = findViewById(R.id.btn_joke);

        jokeViewModel = ViewModelProviders.of(this).get(JokeViewModel.class);
        jokeViewModel.JokeMutableLiveData.observe(this, new Observer<JokeModel>() {
            @Override
            public void onChanged(JokeModel jokeModel) {
                // retrieve data from api model to string
                jokeType = jokeModel.getType();
                setupJoke = jokeModel.getSetup();
                deliveryJoke = jokeModel.getDelivery();
                joke = jokeModel.getJoke();

                showJoke(jokeType, joke, setupJoke, deliveryJoke);
            }
        });

        // when click the button retrieve JokeMutableLiveData when response successfully
        buttonJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jokeViewModel.getJoke();
            }
        });

    }

    private void showJoke(String jokeType, String joke, String setupJoke, String deliveryJoke) {

        welcomeLayout.setVisibility(View.GONE);

        if (jokeType.equals("twopart")) {
            setupTV.setText(setupJoke);
            deliveryTV.setText(deliveryJoke);
            deliveryTV.setVisibility(View.VISIBLE);
        } else if (jokeType.equals("single")) {
            setupTV.setText(joke);
            deliveryTV.setVisibility(View.GONE);
        }
    }

}
