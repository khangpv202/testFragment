package com.example.khangpv.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class MainActivity extends FragmentActivity
{
    private static final String Tag = "MainActivity: ";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d(Tag + this.toString(), " onCreate------------------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentByTag(MainFragment.class.getSimpleName()) == null)
        {
            MainFragment mainFragment = new MainFragment();
            mainFragment.setRetainInstance(true);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, mainFragment, MainFragment.class.getSimpleName()).commit();
        }
    }
}
