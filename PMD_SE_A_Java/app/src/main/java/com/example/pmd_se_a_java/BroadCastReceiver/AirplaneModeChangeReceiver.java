package com.example.pmd_se_a_java.BroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isAirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context, "Airplane mode is On", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Airplane mode is Off", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAirplaneModeOn(Context applicationContext) {
        return Settings.System.getInt(applicationContext.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
