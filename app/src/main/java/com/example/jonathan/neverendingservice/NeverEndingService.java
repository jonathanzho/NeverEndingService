package com.example.jonathan.neverendingservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.jonathan.neverendingservice.utils.ConstantsUtils;

public class NeverEndingService extends Service {
  private static final String TAG = ConstantsUtils.APP_TAG + NeverEndingService.class.getSimpleName();

  public NeverEndingService() {
    Log.d(TAG, "NeverEndingService]");
  }

  public NeverEndingService(Context context) {
    Log.d(TAG, "NeverEndingService: context=[" + context + "]");
  }

  @Override
  public IBinder onBind(Intent intent) {
    Log.d(TAG, "onBind: intent=[" + intent + "]");

    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(TAG, "onStartCommand: startId=[" + startId + "]");

    super.onStartCommand(intent, flags, startId);

    return START_STICKY;
  }

  @Override
  public void onDestroy() {
    Log.d(TAG, "onDestroy");

    super.onDestroy();

    Intent restartServiceIntent = new Intent("com.example.jonathan.ACTION_RESTART_SERVICE");

    sendBroadcast(restartServiceIntent);
  }
}
