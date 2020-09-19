package com.example.myapplication;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BlueToothReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals(BluetoothDevice.ACTION_FOUND))
        {
            Bundle b=intent.getExtras();
            BluetoothDevice b1=b.getParcelable(BluetoothDevice.EXTRA_DEVICE);
            Toast.makeText(context, ""+b1.getName()+"\t"+b1.getAddress(), Toast.LENGTH_SHORT).show();
        }
    }
}
