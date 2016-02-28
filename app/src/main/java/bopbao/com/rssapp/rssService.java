package bopbao.com.rssapp;

import android.content.Intent;

import android.app.IntentService;
import android.os.IBinder;
import android.os.Binder;
import android.os.SystemClock;
import android.util.Log;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Casey on 2016-02-26.
 */
public class rssService extends IntentService {

    public static final String passIn = "in message";
    public static final String passOut = "out message";

    public rssService(){
        super("rssService");
    }

   @Override
   protected void onHandleIntent(Intent workIntent){
       String myMessage = workIntent.getStringExtra(passIn);
       SystemClock.sleep(3000);
       String result = "This is my messaged passed in: " + myMessage;

       Intent broadcastIntent = new Intent();
       broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
       broadcastIntent.putExtra(passOut, result);
   }

}
