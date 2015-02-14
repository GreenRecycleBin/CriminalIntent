package com.greenrecyclebin.android.criminalintent;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static android.content.DialogInterface.OnClickListener;

/**
 * Created by greenrecyclebin on 29/6/14.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    public static final String EXTRA_DATE = "com.greenrecyclebin.android.criminalintent.date";

    public static DatePickerFragment newInstance(Date date) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) getArguments().getSerializable(EXTRA_DATE));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day) {
            @Override
            public void setTitle(CharSequence title) {
                super.setTitle(getResources().getString(R.string.date_picker_title));
            }
        };

        dialog.setButton(BUTTON_POSITIVE, getResources().getString(android.R.string.ok), dialog);
        dialog.setButton(BUTTON_NEGATIVE, "", (OnClickListener) null);

        return dialog;
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent().putExtra(EXTRA_DATE, new GregorianCalendar(year, month, day).getTime());
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }

}
