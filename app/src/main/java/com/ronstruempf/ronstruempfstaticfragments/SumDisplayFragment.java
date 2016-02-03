package com.ronstruempf.ronstruempfstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SumDisplayFragment extends Fragment {

    private TextView _display;

    public SumDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_sum_display, container, false);

        _display = (TextView)theView.findViewById(R.id.displaySum);
        // get a reference to the multiply button and set an onClick handler
        return theView;
    }

    /**
     * Display the sum of two values in the TextView
     *
     * @param n1 First number
     * @param n2 Second number
     */
    public void displaySum(double n1, double n2) {
        double sum = n1 + n2;
        _display.setText(Double.toString(sum));
    }
}
