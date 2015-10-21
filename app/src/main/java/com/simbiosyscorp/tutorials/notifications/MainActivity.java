package com.simbiosyscorp.tutorials.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button toToast, toStatusBar, toDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDialog = (Button) findViewById(R.id.toDialog);
        toToast = (Button) findViewById(R.id.toToast);
        toStatusBar = (Button) findViewById(R.id.toStatusBar);

        toToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ToastActivity.class));
            }
        });
        toStatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StatusBarActivity.class));

            }
        });
        toDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DialogActivity.class));

            }
        });
    }
}
