package com.wang.avi.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;

import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public class IndicatorActivity extends AppCompatActivity{

    private AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);

        String indicator=getIntent().getStringExtra("indicator");
        int duration = getIntent().getIntExtra("duration", 0);
        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setAnimationDuration(duration);
        avi.setIndicator(indicator);
        setUpDialog();
    }

    public void hideClick(View view) {
        avi.hide();
        // or avi.smoothToHide();
    }

    public void showClick(View view) {
        avi.show();
        // or avi.smoothToShow();
    }

    public void durationClick(View view) {
        dialog.show();
    }

    private EditText editText;
    private AlertDialog dialog;
    private void setUpDialog(){
        editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(5)});
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20,
                getResources().getDisplayMetrics());
        dialog = new AlertDialog.Builder(this)
                .setTitle("Animation duration")
                .setMessage("Enter desired animation duration in milliseconds.")
                .setView(editText, padding, padding, padding,  padding)
                .setPositiveButton("APPLY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String duration = editText.getText().toString().trim();
                        if (!duration.isEmpty()) {
                            setIntent(getIntent().putExtra("duration", Integer.parseInt(duration)));
                            recreate();
                        }
                    }
                })
                .setNegativeButton("CANCEL", null)
                .create();

    }

}
