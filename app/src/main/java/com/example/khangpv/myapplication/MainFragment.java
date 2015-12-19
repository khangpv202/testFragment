package com.example.khangpv.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment
{
    private static final String Tag = "khang_MainFragment: ";
    CycleCountFragment cycleCountFragment;
    FullCountFragment fullCountFragment;

    public MainFragment()
    {
        Log.d(Tag, "new MainFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

//        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Log.d(Tag + this.toString(), " onCreateView");
        if (getFragmentManager().findFragmentByTag(CycleCountFragment.class.getSimpleName()) == null)
        {
            cycleCountFragment = new CycleCountFragment();
            fullCountFragment = new FullCountFragment();
            fragmentTransaction.add(R.id.fragmentContent, cycleCountFragment, CycleCountFragment.class.getSimpleName())
                    .add(R.id.fragmentContent, fullCountFragment, FullCountFragment.class.getSimpleName())
                    .hide(fullCountFragment).commit();
        }
        else
        {
            cycleCountFragment = (CycleCountFragment) getFragmentManager().findFragmentByTag(CycleCountFragment.class.getSimpleName());
            fullCountFragment = (FullCountFragment) getFragmentManager().findFragmentByTag(FullCountFragment.class.getSimpleName());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                if (checkedId == R.id.cycleCount)
                {
                    fragmentTransaction.hide(fullCountFragment);
                    fragmentTransaction.show(cycleCountFragment);
                }
                else
                {
                    fragmentTransaction.hide(cycleCountFragment);
                    fragmentTransaction.show(fullCountFragment);
                }
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView()
    {
        Log.d(Tag + this.toString(), " onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy()
    {
        Log.d(Tag + this.toString(), " onDestroy");
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context)
    {
        Log.d(Tag + this.toString(), " onAttach");
        super.onAttach(context);
    }

    @Override
    public void onDetach()
    {
        Log.d(Tag + this.toString(), " onDetach");
        super.onDetach();
    }
}
