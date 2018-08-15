package com.example.seekbaralert;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.widget.SeekBar;

public class SeekbarAlert {
    private int currentProgress = 0;
    private Context mContext;
    private String mAlertMessage = "";
    private int mTheme;

    public SeekbarAlert(Context context) {
        mContext = context;
    }

    public SeekbarAlert(Context context, String alert_mess) {
        mContext = context;
        mAlertMessage = alert_mess;
    }

    public SeekbarAlert(Context context, String alert_mess, @StyleRes int theme) {
        mContext = context;
        mAlertMessage = alert_mess;
        mTheme = theme;
    }

    public void build() {
        AlertDialog.Builder builder;

        if (mTheme == 0) {
            builder = new AlertDialog.Builder(mContext);
        } else {
            builder = new AlertDialog.Builder(mContext, mTheme);
        }

        builder.setTitle(mAlertMessage);

        final SeekBar seekbar = new SeekBar(mContext);
        /**Setting the current seekbar progress to the current size of the brush**/
        seekbar.setProgress(currentProgress);
        /**Setting the view of the alert dialog to the seekbar**/
        builder.setView(seekbar);

        /**Setting the seekbar listener to capture when the user changes the progress to change the brush size**/
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public int getSeekbarProgress() {
        return currentProgress;
    }
}

