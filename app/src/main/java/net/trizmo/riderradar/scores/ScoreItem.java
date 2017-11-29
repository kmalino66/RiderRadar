package net.trizmo.riderradar.scores;

/**
 * Created by trizm on 11/28/2017.
 */

public class ScoreItem {

    private String scoreDescriptor;
    private int score;

    public ScoreItem(String scoreDescriptor, int score)
    {
        this.scoreDescriptor = scoreDescriptor;
        this.score = score;
    }

    public String getScoreDescriptor()
    {
        return scoreDescriptor;
    }

    public int getScore()
    {
        return score;
    }
}
