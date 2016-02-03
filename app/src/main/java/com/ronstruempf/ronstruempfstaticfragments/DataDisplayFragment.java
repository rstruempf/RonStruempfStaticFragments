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

    private double firstNumber;
    private double secondNumber;
    private double product = 0;

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void multiply() {
        product = firstNumber * secondNumber;
    }

    public void displayProduct() {
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
