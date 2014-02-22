package com.greenrecyclebin.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

/**
 * Created by greenrecyclebin on 22/2/14.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }

}
