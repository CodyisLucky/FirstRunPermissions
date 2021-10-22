package com.codyislucky.firstrunpermissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context;
    SharedPreferences prefs;
    TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        prefs = context.getSharedPreferences("appPrefs", 0);

        txtHello = findViewById(R.id.txt_Hello);

        if(getFirstRun()){
            setRan();
            //anything you want to do in the first run

            txtHello.setText("Hello First Time User");

        }
        else{
            //this is not the first run
            txtHello.setText("'Sup returning user?");
        }
    }

    boolean getFirstRun(){
        return prefs.getBoolean("firstRun", true);
    }

    void setRan(){
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean("firstRun", false);
        edit.commit();
    }
}