package net.trizmo.riderradar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import net.trizmo.riderradar.scores.ScoreItem;
import net.trizmo.riderradar.scores.ScoreItemAdapter;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    public static String EXTRA_ARRAY_LIST = "EXTRA_ARRAY_LIST";

    private ScoreItemAdapter scoreItemAdapter;
    private ArrayList<ScoreItem> descriptionItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        descriptionItems = this.getIntent().getParcelableArrayListExtra(EXTRA_ARRAY_LIST);
    }

    private void bindAdapter() {
        if (descriptionItems != null && descriptionItems.size() > 0) {
            scoreItemAdapter = new ScoreItemAdapter(this, descriptionItems);
            ListView detailsList = (ListView) findViewById(R.id.details_listview);
            detailsList.setAdapter(scoreItemAdapter);
        }
    }
}