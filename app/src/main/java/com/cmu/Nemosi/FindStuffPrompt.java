package com.cmu.Nemosi;

import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.media.RingtoneManager;
import android.media.AudioManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.PowerManager;

import android.view.View;

public class FindStuffPrompt extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_stuff_prompt);

        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mp.setDataSource(getApplicationContext(), alert);
            mp.prepare();
            mp.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void openTile(View v) {
        if (mp != null) mp.release();
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.thetileapp.tile");
        startActivity(intent);
    }

    public void cancel(View v) {
        if (mp != null) mp.release();
        onBackPressed();
        onBackPressed();
    }

    @Override
    public void onDestroy() {
        if (mp != null) mp.release();
        super.onDestroy();
    }


    @Override
    public void onResume() {
        if (!mp.isPlaying()) mp.start();
        super.onResume();
    }

    @Override
    public void onPause() {
//        PowerManager powerManager = (PowerManager) getSystemService(FindStuffPrompt.this.POWER_SERVICE);
//        boolean isScreenAwake = powerManager.isScreenOn();
//        if (isScreenAwake && mp.isPlaying()) {
//            mp.stop();
//        }
        super.onPause();
    }

}
