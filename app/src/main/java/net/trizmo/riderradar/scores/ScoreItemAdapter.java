package net.trizmo.riderradar.scores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.trizmo.riderradar.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by trizm on 11/29/2017.
 */

public class ScoreItemAdapter extends BaseAdapter {

    ArrayList<ScoreItem> items;
    Context context;

    public ScoreItemAdapter(Context context, ArrayList<ScoreItem> items)
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.details_item, viewGroup, false);
        TextView detailText = (TextView) rowView.findViewById(R.id.desc_textview);
        TextView scoreText = (TextView) rowView.findViewById(R.id.score_textview);

        ScoreItem item = (ScoreItem)getItem(i);

        detailText.setText(item.getScoreDescriptor());
        scoreText.setText(item.getScore());

        return rowView;
    }
}
