package com.cmu.Nemosi;

import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import android.util.Log;
import android.view.WindowManager;
import android.content.pm.PackageManager;

import java.util.Date;

import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;


public class FlicReceiver extends FlicBroadcastReceiver {
    @Override
    protected void onRequestAppCredentials(Context context) {
        FlicManager.setAppCredentials("f010dee3-b418-484b-b4be-c3ccdb167820", "7d40d5ad-7384-42b2-b154-76eb7a59bc8e", "Nemosi");
    }

    @Override
    public void onButtonUpOrDown(Context context, FlicButton button, boolean wasQueued, int timeDiff, boolean isUp, boolean isDown) {
        if (isDown) {
            Intent i = new Intent(context, FindStuffPrompt.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    @Override
    public void onButtonRemoved(Context context, FlicButton button) {
        Log.d("yo", "removed");
        Toast.makeText(context, "Button was removed", Toast.LENGTH_SHORT).show();
    }
}