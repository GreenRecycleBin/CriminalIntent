package com.greenrecyclebin.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by greenrecyclebin on 18/3/14.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
