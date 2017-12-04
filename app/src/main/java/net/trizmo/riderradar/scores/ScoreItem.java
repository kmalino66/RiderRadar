package net.trizmo.riderradar.scores;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by trizm on 11/28/2017.
 */

public class ScoreItem implements Parcelable {

    private String scoreDescriptor;
    private int score;

    public ScoreItem(String scoreDescriptor, int score)
    {
        this.scoreDescriptor = scoreDescriptor;
        this.score = score;
    }

    public ScoreItem(Parcel in) {
        scoreDescriptor = in.readString();
        score = in.readInt();
    }

    public String getScoreDescriptor()
    {
        return scoreDescriptor;
    }

    public int getScore()
    {
        return score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(scoreDescriptor);
        dest.writeInt(score);

    }

    /**
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays
     *
     * If you don’t do that, Android framework will raises an exception
     * Parcelable protocol requires a Parcelable.Creator object
     * called CREATOR
     */
    public static final Parcelable.Creator<ScoreItem> CREATOR = new Parcelable.Creator<ScoreItem>() {

        public ScoreItem createFromParcel(Parcel in) {
            return new ScoreItem(in);
        }

        public ScoreItem[] newArray(int size) {
            return new ScoreItem[size];
        }
    };

}
