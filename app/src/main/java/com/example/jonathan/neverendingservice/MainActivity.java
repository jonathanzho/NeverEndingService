package com.example.jonathan.neverendingservice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jonathan.neverendingservice.utils.ConstantsUtils;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = ConstantsUtils.APP_TAG + MainActivity.class.getSimpleName();

  private Context mContext;
  private NeverEndingService mNeverEndingService;
  private Intent mServiceIntent;

  public Context getContext() {
    return this;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mContext = this;

    mNeverEndingService = new NeverEndingService(mContext);

    mServiceIntent = new Intent(mContext, mNeverEndingService.getClass());

    if (!getServiceRunningStatus(mNeverEndingService.getClass())) {
      startService(mServiceIntent);
    }

    Log.v(TAG, "onCreate: end");
  }

  @Override
  protected void onDestroy() {
    Log.d(TAG, "onDestroy");

    super.onDestroy();

    stopService(mServiceIntent);
  }

  private boolean getServiceRunningStatus(Class<?> serviceClass) {
    boolean isServiceRunning = false;

    ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

    for (ActivityManager.RunningServiceInfo serviceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
      if (serviceClass.getName().equals(serviceInfo.service.getClassName())) {
        isServiceRunning = true;
        break;
      }
    }

    Log.v(TAG, "getServiceRunningStatus: isServiceRunning=[" + isServiceRunning + "]");

    return isServiceRunning;
  }
}
