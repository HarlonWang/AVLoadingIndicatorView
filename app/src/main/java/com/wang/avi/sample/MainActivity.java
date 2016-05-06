package com.wang.avi.sample;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        if (toolbar!=null){
            setSupportActionBar(toolbar);
            toolbar.setTitle("AVI");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings){
            final AVLoadingIndicatorDialog dialog=new AVLoadingIndicatorDialog(this);
            dialog.setMessage("Loading");
            dialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.cancel();
                }
            },2000);
        }
        return super.onOptionsItemSelected(item);
    }
}
