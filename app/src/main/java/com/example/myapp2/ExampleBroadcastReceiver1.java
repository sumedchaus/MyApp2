package com.example.myapp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver1  extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show();
        }
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Toast.makeText(context, "Connectivity changed", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(context, "ExampleBroadcastReceiver1 onReceive()", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Toast.makeText(context, "SMS Received", Toast.LENGTH_SHORT).show();

        }
        batteryIndicator(context,intent);

    }

    void  batteryIndicator(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        Toast.makeText(context, "Battery Percentage: " + level, Toast.LENGTH_SHORT).show();

        // textView.setText("Battery Percentage: " + level);
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status ==
                BatteryManager.BATTERY_STATUS_FULL;
        if (isCharging) {
            Toast.makeText(context, "Charger connected, Battery Charging..", Toast.LENGTH_SHORT).show();
        }
        else if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
            Toast.makeText(context, "Charger disconnected",
                    Toast.LENGTH_SHORT).show();
        }

    }
}