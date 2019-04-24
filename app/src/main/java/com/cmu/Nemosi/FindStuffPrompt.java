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
    int priorVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_stuff_prompt);

        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        if (mp != null) mp.release();
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        AudioManager audio = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        priorVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
        try {
            mp.setDataSource(getApplicationContext(), alert);
            mp.prepare();
            mp.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void openTile(View v) {
        if (mp.isPlaying()) mp.stop();
        AudioManager audio = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, priorVolume, 0);
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.thetileapp.tile");
        startActivity(intent);
    }

    public void cancel(View v) {
        if (mp.isPlaying()) mp.stop();
        AudioManager audio = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, priorVolume, 0);
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        AudioManager audio = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, priorVolume, 0);
        if (mp != null) mp.release();
    }
}
