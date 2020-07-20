package com.example.prudhvi.broadacast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
    mp=MediaPlayer.create(context,R.raw.getcloser);
    mp.start();
        Toast.makeText(context, "Alarm", Toast.LENGTH_SHORT).show();
    }
}
