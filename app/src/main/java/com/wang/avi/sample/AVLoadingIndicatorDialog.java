package com.wang.avi.sample;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Jack Wang on 2016/5/6.
 */
public class AVLoadingIndicatorDialog extends AlertDialog {

    private TextView mMessageView;

    public AVLoadingIndicatorDialog(Context context) {
        super(context);
        View view=LayoutInflater.from(getContext()).inflate(R.layout.progress_avld,null);
        mMessageView= (TextView) view.findViewById(R.id.message);
        setView(view);
    }


    @Override
    public void setMessage(CharSequence message) {
        mMessageView.setText(message);
    }
}
