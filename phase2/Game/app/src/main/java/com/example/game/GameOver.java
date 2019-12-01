package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.models.Interfaces.ActivityDataResponseActions;
import com.example.game.models.ActivityDataUseCases;
import com.example.game.presenters.ActivityDataPresenter;
import com.example.game.viewLevel.MainActivity;

public class GameOver extends AppCompatActivity implements ActivityDataResponseActions {

    private ActivityDataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over2);

        getWindow().getDecorView().setBackgroundResource(BaseActivity.account.getBackground());

        presenter = new ActivityDataPresenter(this, new ActivityDataUseCases());
    }

    public void resetAndMove(View view) {
        presenter.resetDataValues(getApplicationContext().getFilesDir());
    }

    @Override
    public void reactToReset() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
