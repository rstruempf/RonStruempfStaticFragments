package com.ronstruempf.ronstruempfstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SumDisplayFragment extends Fragment {


    public SumDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sum_display, container, false);
    }

    /*
    public void displaySum(double n1, double n2) {
        double sum = n1 + n2;
        _display.setText(Double.toString(sum));
    }
    */
}
