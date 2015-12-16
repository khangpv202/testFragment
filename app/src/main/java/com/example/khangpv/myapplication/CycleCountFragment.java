package com.example.khangpv.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class CycleCountFragment extends Fragment
{
    private static final String Tag = "khang_Cycle: ";

    public CycleCountFragment()
    {
        Log.d(Tag,"new Fragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.cycle_count, container, false);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        Log.d(Tag + this.toString(), " onDestroyView");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(Tag + this.toString(), " onDestroy");
    }
}
