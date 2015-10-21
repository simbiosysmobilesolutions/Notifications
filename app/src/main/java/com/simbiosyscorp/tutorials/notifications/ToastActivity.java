package com.simbiosyscorp.tutorials.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
Button toastNotification,customToastNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toastNotification= (Button) findViewById(R.id.toastBtn);
        customToastNotification= (Button) findViewById(R.id.customToastBtn);

        toastNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Simple Toast Notification
                Toast.makeText(getApplicationContext(),"This is a TOAST Notification",Toast.LENGTH_LONG).show();
            }
        });

        customToastNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inflating layout for Custom Toast
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                //Setting values for the views inside the layout for custom Toast
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Hello! This is a custom toast!");

                //Creating the Custom Toast
                Toast toast = new Toast(getApplicationContext());
                //Gravity makes the toast appear in the desired place on the screen
                //Center in this example
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                //Sets Duration of Display
                toast.setDuration(Toast.LENGTH_LONG);
                //Custom Layout
                toast.setView(layout);
                //Shows the Toast
                toast.show();
            }
        });
    }

}
