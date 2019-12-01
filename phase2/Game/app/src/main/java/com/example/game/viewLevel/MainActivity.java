package com.example.game.viewLevel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.game.BaseActivity;
import com.example.game.R;
import com.example.game.models.LoadGameActions;
import com.example.game.models.MainLoadUseCases;
import com.example.game.presenters.MainLoadPresenter;
import com.example.game.viewLevel.game1.Game1Activity;
import com.example.game.viewLevel.game1.GameOverActivity;
import com.example.game.viewLevel.game2.Game2Activity;
import com.example.game.viewLevel.game3.Game3Activity;
import com.example.game.viewLevel.game3.Game3ExitActivity;

/**
 * Main menu activity in which the player may navigate to the settings menu, load their game from
 * the previous point they left off at or start a new game.
 */
public class MainActivity extends BaseActivity implements LoadGameActions {
    /**
     * Text displaying player stats. addCoun is for addition counter, a counter for number of games
     * played including retries.
     */
    private TextView addCoun, lives, scores;

    /**
     * The presenter for this activity.
     */
    MainLoadPresenter presenter;

    /**
     * Code to execute when the Activity is created.
     *
     * @param savedInstanceState A Bundle containing possibly previous states of this Activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView icon = findViewById(R.id.User_Icon);

        getWindow().getDecorView().setBackgroundResource(account.getBackground());

        presenter = new MainLoadPresenter(this, new MainLoadUseCases());

        icon.setImageResource(account.getIcon());

        addCoun = findViewById(R.id.addCoun_MainActivity);
        addCoun.setText(String.valueOf(account.getGamesPlayed()));

        lives = findViewById(R.id.livesText_MainActivity);
        lives.setText(String.valueOf(account.getHitPoints()));

        scores = findViewById(R.id.scoreText_MainActivity);
        scores.setText(String.valueOf(account.getCurrentScore()));
    }

    /**
     * Actions taken if resume game button is clicked
     * @param view the button clicked
     */
    public void resumeGame(View view) {
        presenter.resume(getApplicationContext().getFilesDir());
    }

    /**
     * Called when the user taps the "Settings" button
     */
    public void openOptions(View view) {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    /**
     * Actions taken if game 1 button is clicked
     * @param view the button clicked
     */
    public void game1(View view) {
        presenter.game1(getApplicationContext().getFilesDir());
    }

    /**
     * Actions taken if game 2 button is clicked
     * @param view the button clicked
     */
    public void game2(View view) {
        presenter.game2(getApplicationContext().getFilesDir());
    }

    /**
     * Actions taken if game 3 button is clicked
     * @param view the button clicked
     */
    public void game3(View view) {
        presenter.game3(getApplicationContext().getFilesDir());
    }

    /**
     * Move to game 1
     */
    @Override
    public void toGame1() {
        Intent intent = new Intent(this, Game1Activity.class);
        startActivity(intent);
    }

    /**
     * Move to game 2
     */
    @Override
    public void toGame2() {
        Intent intent = new Intent(this, Game2Activity.class);
        startActivity(intent);
    }

    /**
     * Move to game 3
     */
    @Override
    public void toGame3() {
        Intent intent = new Intent(this, Game3Activity.class);
        startActivity(intent);
    }

    /**
     * Move to after game 1
     */
    @Override
    public void toAfterGame1(){
        Intent intent = new Intent(this, GameOverActivity.class);
        startActivity(intent);
    }

    /**
     * Move to after game 3
     */
    @Override
    public void toAfterGame3(){
        Intent intent = new Intent(this, Game3ExitActivity.class);
        startActivity(intent);
    }
}
