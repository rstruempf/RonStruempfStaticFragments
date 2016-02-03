package com.ronstruempf.ronstruempfstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Second {@link Fragment} for displaying product and button for sum
 */
public class DataDisplayFragment extends Fragment {

    private TextView _display;

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    public void displayProduct(double n1, double n2) {
        double product = n1 * n2;
        _display.setText(Double.toString(product));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        _display = (TextView)theView.findViewById(R.id.displayProduct);
        return theView;
    }

}
