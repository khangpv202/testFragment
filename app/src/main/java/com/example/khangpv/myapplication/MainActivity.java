package com.example.khangpv.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
