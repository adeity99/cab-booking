package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class BlueToothDemo extends AppCompatActivity {
    Switch s;
    BluetoothAdapter ba;
    BlueToothReciver btr;
    IntentFilter ifr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth_demo);
        s = findViewById(R.id.switch2);
        ba = BluetoothAdapter.getDefaultAdapter();
        if (ba != null) {
            s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (!ba.isEnabled()) {
                            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivity(intent);
                            s.setText("BLUTOOTH ON");
                        }
                    } else {
                        if (ba.isEnabled()) {
                            ba.disable();
                            s.setText("BLUETOOTH OFF");
                        }
                    }
                }
            });
        } else {
            Toast.makeText(this, "PROBLEM", Toast.LENGTH_SHORT).show();
        }
        ifr = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        btr = new BlueToothReciver();
        registerReceiver(btr, ifr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ba != null)
            ba.startDiscovery();
    }
}
