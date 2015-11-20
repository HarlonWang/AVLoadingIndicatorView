package com.wang.avi.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
    }


    public void visible(View view) {
        findViewById(R.id.testView).setVisibility(View.VISIBLE);
    }

    public void gone(View view) {
        findViewById(R.id.testView).setVisibility(View.GONE);
    }

    public void invisible(View view) {
        findViewById(R.id.testView).setVisibility(View.INVISIBLE);
    }
}
