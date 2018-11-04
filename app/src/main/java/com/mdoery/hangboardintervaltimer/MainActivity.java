package com.mdoery.hangboardintervaltimer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtFeedback;
    private TextView editText;
/*
    A user will input the interval time.
    At first I thought TextView input but now I'm thinking something very similar to the timer that
    comes w my device. This appears to have an Apache License, so I'll check to see if it can be
    incorporated.
    I like the idea of using a roll-y thing to flip through HH:MM:SS
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFeedback = (TextView) findViewById(R.id.txtFeedback);

        /*
        Button btnAddInterval = (Button) findViewById(R.id.btnAddInterval);
        btnAddInterval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                log("Add Interval Button Clicked! " + text);
            }
        });
        */
        Button btnStart = (Button) findViewById(R.id.startToggleButton);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log("Start Button Clicked!!");
            }
        });
    }

    private void log(String msg) {
        System.out.println(msg);
        txtFeedback.setText(msg);
    }

}