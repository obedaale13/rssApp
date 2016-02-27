package bopbao.com.rssapp;

import android.content.Intent;
import android.app.Service;
import android.os.IBinder;
import android.os.Binder;

/**
 * Created by Casey on 2016-02-26.
 */
public class rssService extends Service {

    private final IBinder rssBinder = new MyLocalBinder();

    public rssService(){

    }

    @Override
    public IBinder onBind(Intent i){
       return rssBinder;
    }

    public class MyLocalBinder extends Binder{
        rssService getService(){
            return rssService.this;
        }
    }

    public String getString (){
        String test = "Hello";
        return test;
    }
}
