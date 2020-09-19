package com.example.myapplication;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.widget.Toast;

import java.util.Date;

class MyPhoneListener extends PhoneStateListener {
    private static int ls= TelephonyManager.CALL_STATE_IDLE;
    private static Date cs;
    private static boolean incoming;
    public void onCallStateChange(Context context, int state, String phone_n)
    {
      if(ls==state)
      {
          return;
      }
        Toast.makeText(context, ""+phone_n, Toast.LENGTH_SHORT).show();
      switch(state)
      {
          case TelephonyManager.CALL_STATE_RINGING:
              incoming=true;
              cs=new Date();
              Toast.makeText(context, "YOU HAVE INCOMING CALL"+phone_n, Toast.LENGTH_SHORT).show();
              break;
          case TelephonyManager.CALL_STATE_OFFHOOK:
              if(ls!=TelephonyManager.CALL_STATE_RINGING)
              {
                  incoming=false;
                  cs=new Date();
                  Toast.makeText(context, "CALL STARTED", Toast.LENGTH_SHORT).show();
              }
              break;
          case TelephonyManager.CALL_STATE_IDLE:
              if(ls==TelephonyManager.CALL_STATE_RINGING)
              {
                  Toast t=Toast.makeText(context, "MISSED CALL" +phone_n+"TIME"+cs, Toast.LENGTH_SHORT);
                  t.setGravity(Gravity.CENTER,0,0);
                  t.show();
              }
              else if(incoming)
              {
                  Toast.makeText(context, "INCOMING CALL" +phone_n+"TIME"+cs, Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(context, "OUTGOING" +phone_n+"TIME"+cs, Toast.LENGTH_SHORT).show();
              }
              break;
      }
      ls=state;
    }



}
