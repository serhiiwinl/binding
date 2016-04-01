package com.mycompany.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.others.CommonInit;
import com.mycompany.myapp.others.Platform;

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

                counterTextView.setText("Click Nr. " + 1);
            }
        });
    }

    private void initAll() {
        BrandComponentFactory.getInstance().init(new Platform() {
            @Override
            public String getType() {
                return Platform.AN;
            }
        });
        new CommonInit();
    }
}
