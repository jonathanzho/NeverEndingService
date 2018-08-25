package com.example.jonathan.neverendingservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.jonathan.neverendingservice.utils.ConstantsUtils;

public class RestartServiceReceiver extends BroadcastReceiver {
  private static final String TAG = ConstantsUtils.APP_TAG + RestartServiceReceiver.class.getSimpleName();

  @Override
  public void onReceive(Context context, Intent intent) {
    Log.d(TAG, "onReceive");
  }
}
