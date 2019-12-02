package com.example.game.models.game3;

import android.content.Context;
import android.content.res.Resources;

import com.example.game.R;

import static com.example.game.BaseActivity.account;

/**
 * Class that manages the status of the game.
 */
public class GameStatusManager {

    /**
     * Additional resources needed for the game.
     */
    private final Resources res;

    /**
     * Class that manages the game objects.
     */
    private final GameObjectManager gameObjectManager;

    /**
     * Constructor.
     *
     * @param res               Additional resources needed for the game.
     * @param gameObjectManager Class that manages the game objects.
     */
    public GameStatusManager(Resources res, GameObjectManager gameObjectManager) {
        this.res = res;
        this.gameObjectManager = gameObjectManager;
    }

    /**
     * Checks if the game has ended.
     *
     * @param hitPoints The score of the game.
     * @param context   The context of the game, needed for accessing additional files.
     */
    public boolean gameEnded(int hitPoints, Context context) {
        boolean status = (gameObjectManager.getEnemyHealth().getHealthLevel() == 0 ||
                gameObjectManager.getPlayerHealth().getHealthLevel() == 0);

        //checks if game has ended. If it has it updates stats.
        if (status) {
            account.incrementLevel(context.getApplicationContext().getFilesDir());
            //Increases the score by the number of hitPoints
            account.incrementScore(hitPoints, context.getApplicationContext().getFilesDir());
            //Decreases the number of lives
            account.decrementHitPoints((100 - hitPoints) / 10,
                    context.getApplicationContext().getFilesDir());
            //Adds 1 to number of games played
            account.incrementGamesPlayed(context.getApplicationContext().getFilesDir());
        }

        return status;
    }

    /**
     * Check's which one of the CharacterObjects is the winner (The enemy or the Player) and return
     * string that displays the result of the game.
     *
     * @return result : The result of the game.
     */
    public String checkWinner() {
        if (gameObjectManager.getPlayerHealth().getHealthLevel() == 0 &&
                gameObjectManager.getEnemyHealth().getHealthLevel() != 0) {
            return res.getString(R.string.lost);
        } else {
            return res.getString(R.string.win);
        }
    }
}
