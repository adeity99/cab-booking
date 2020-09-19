package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyCallReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager tm=(TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        MyPhoneListener mpl=new MyPhoneListener();
        tm.listen(mpl,PhoneStateListener.LISTEN_CALL_STATE);
        Bundle b=intent.getExtras();
        String phone_n=b.getString("incoming_number");
        String stateSt=b.getString(TelephonyManager.EXTRA_STATE);
        int state=0;
        if(stateSt.equals(TelephonyManager.EXTRA_STATE_IDLE))
        {
            state=TelephonyManager.CALL_STATE_IDLE;
        }
        else if(stateSt.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
        {
            state=TelephonyManager.CALL_STATE_OFFHOOK;
        }
        else if(stateSt.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {
            state=TelephonyManager.CALL_STATE_RINGING;
        }
        if(phone_n==null||"".equals(phone_n))
        {
            return;
        }
        mpl.onCallStateChange(context,state,phone_n);
        Toast.makeText(context, "PHONE NUMBER"+phone_n, Toast.LENGTH_SHORT).show();
    }
}
