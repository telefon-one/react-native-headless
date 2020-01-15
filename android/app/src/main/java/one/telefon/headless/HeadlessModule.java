package one.telefon.headless;

import android.app.Activity;
import android.app.Service;

import android.view.Window;
import android.view.WindowManager;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import android.os.Process;
import android.os.PowerManager;

import android.content.Context.POWER_SERVICE;

import android.os.Handler;
import android.os.HandlerThread;

import com.facebook.react.bridge.*;
import com.facebook.react.ReactActivity;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import android.os.PowerManager;



public class HeadlessModule extends ReactContextBaseJavaModule {
    ReactApplicationContext mContext;

    private static String LOG = "telefon.one.headless.HeadlessModule";
    private PowerManager mPowerManager;
    private HandlerThread mWorkerThread;
    private Handler mHandler;

    public HeadlessModule(ReactApplicationContext context) {
        super(context);
        mContext=context;

        mWorkerThread = new HandlerThread(getClass().getSimpleName(), Process.THREAD_PRIORITY_FOREGROUND);
        mWorkerThread.setPriority(Thread.MAX_PRIORITY);
        mWorkerThread.start();
        mHandler = new Handler(mWorkerThread.getLooper());
    }
    
    @Override
    public String getName() {
        return "HeadlessModule";
    }

    @ReactMethod
    public void toForeground() {
        Log.d(LOG, "toForeground()");

        /*
         * PowerManager.WakeLock wl = mPowerManager.newWakeLock(
         * PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE |
         * PowerManager.FULL_WAKE_LOCK, "incoming_call" ); wl.acquire(10000);
         */

        Boolean mAppHidden = true;
        if (mAppHidden) {
            try {
                String ns = mContext.getPackageName();
                String cls = ns + ".MainActivity";

                Intent intent = new Intent(mContext, Class.forName(cls));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.EXTRA_DOCK_STATE_CAR);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.putExtra("foreground", true);

                mContext.startActivity(intent);
            } catch (Exception e) {
                Log.w(LOG, "Failed to open application on received call", e);
            }
        }

        job(new Runnable() {
            @Override
            public void run() {
                // Brighten screen at least 10 seconds
                mPowerManager = (PowerManager) mContext.getSystemService(POWER_SERVICE);

                PowerManager.WakeLock wl = mPowerManager.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP
                        | PowerManager.ON_AFTER_RELEASE | PowerManager.FULL_WAKE_LOCK, "incoming_call");
                wl.acquire(10000);

            }
        });

    }


   /*
   * Additional step: Ability to answer incoming call without Lock Screen
   */
  
    @ReactMethod
    public void noLock(Bundle savedInstanceState) {
      //super.onCreate(savedInstanceState);
  
      //Window w = getWindow();
      //w.setFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED, WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
  
      //toForeg?
    }

    @ReactMethod
    public void toBackground() {
    }


    private void job(Runnable job) {
        mHandler.post(job);
    }
}






