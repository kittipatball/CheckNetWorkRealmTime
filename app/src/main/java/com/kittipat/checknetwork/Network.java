package com.kittipat.checknetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by gissoft95_hp on 24-Nov-16.
 */

public class Network extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE );

        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isConnectedWifi = wifi != null && wifi.isConnectedOrConnecting();
        boolean isConnectedMobile = mobile != null && mobile.isConnectedOrConnecting();

        if (isConnectedWifi || isConnectedMobile){
            if (isConnectedMobile){
                Log.i("NET", "ConnectMobile " +isConnectedMobile);
                Log.i("NET", "ConnectWifi " +isConnectedWifi);
            }else{
                Log.i("NET", "ConnectWifi" +isConnectedWifi);
                Log.i("NET", "ConnectMobile" +isConnectedMobile);
            }
        } else {
            Log.i("NET", "not connect false" );
        }
    }
}

