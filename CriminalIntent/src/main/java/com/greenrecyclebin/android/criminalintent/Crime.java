package com.greenrecyclebin.android.criminalintent;

import java.util.UUID;

/**
 * Created by greenrecyclebin on 18/1/14.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
    
}
