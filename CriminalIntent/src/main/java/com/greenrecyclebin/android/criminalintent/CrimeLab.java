package com.greenrecyclebin.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by greenrecyclebin on 22/2/14.
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<>();

        for (int i = 0; i < 100; ++i)
            mCrimes.add(new Crime("Crime #" + i, i % 2 == 0));
    }

    public static synchronized CrimeLab get(Context c) {
        if (sCrimeLab == null)
            sCrimeLab = new CrimeLab(c.getApplicationContext());

        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes)
            if (c.getId().equals(id))
                return c;

        return null;
    }

}
