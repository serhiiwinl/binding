package com.partypoker.poker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.partypoker.poker.others.CommonInit;
import com.partypoker.poker.trackers.impl.AppUsageTracker;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my);


        initAll();

        final TextView counterTextView = (TextView) findViewById(R.id.counterTextView);
        final Button counterButton = (Button) findViewById(R.id.counterButton);


        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppUsageTracker.getInstance().trackLoginSuccess("testUser","sdsdse11223dssd");
                counterTextView.setText("Click Nr. " + 1);
            }
        });
    }

    private void initAll() {
        new CommonInit();
    }
}