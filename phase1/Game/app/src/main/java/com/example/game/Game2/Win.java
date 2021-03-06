package com.example.game.Game2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.game.Account;
import com.example.game.BaseActivity;
import com.example.game.Game3.Game3Activity;
import com.example.game.R;

public class Win extends BaseActivity {
    Account account;

    /**
     * Text displaying player stats
     */
    TextView lives, scores;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_win);

        account = (Account) getIntent().getSerializableExtra("ac");

        if (account.getCustomization()[0] == 1) {
            getWindow().getDecorView().setBackgroundResource(R.color.background1);
        }

        lives = findViewById(R.id.livesText_Win);
        lives.setText(String.valueOf(account.getSave()[1]));

        scores = findViewById(R.id.scoreText_Win);
        scores.setText(String.valueOf(account.getSave()[2]));
    }

    /** Called when the user taps the "To Game Three" button */
    public void nextGame(View view) {
        Intent intent = new Intent(this, Game3Activity.class);
        intent.putExtra("ac", account);
        startActivity(intent);
    }
}