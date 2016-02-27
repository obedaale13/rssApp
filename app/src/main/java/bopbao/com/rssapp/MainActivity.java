package bopbao.com.rssapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.widget.TextView;

import java.util.Arrays;

import bopbao.com.rssapp.rssService.MyLocalBinder;


public class MainActivity extends AppCompatActivity {
    rssService getService = new rssService();
    boolean isBound = false;


    public void showString() {
        String[] X = getService.getString();
        String x = Arrays.toString(X);
        TextView testView = (TextView) findViewById(R.id.test_text);
        testView.setText(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, rssService.class);
        bindService(i, rssConnection, Context.BIND_AUTO_CREATE);
        showString();
    }

    private ServiceConnection rssConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            getService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        isBound = false;
        }
    };

}
