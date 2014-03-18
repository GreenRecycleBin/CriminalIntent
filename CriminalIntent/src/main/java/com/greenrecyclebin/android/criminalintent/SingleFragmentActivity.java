package com.greenrecyclebin.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by greenrecyclebin on 18/3/14.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainter);

        if (fragment == null) {
            fragment = createFragment();
            manager.beginTransaction().add(R.id.fragmentContainter, fragment).commit();
        }
    }

    protected abstract Fragment createFragment();

}
