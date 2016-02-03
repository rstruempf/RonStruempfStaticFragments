package com.ronstruempf.ronstruempfstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * First {@link Fragment} for entry of two numbers and product button
 */
public class DataEntryFragment extends Fragment {

    private EditText _first;
    private EditText _second;

    public interface MultiplyListener {
        void onMultiply();
    }

    private MultiplyListener _listener;

    public DataEntryFragment() {
        // Required empty public constructor
    }

    public double getFirstNumber() {
        try {
            return Double.parseDouble(this._first.getText().toString());
        }
        catch (Exception ex) {
            Log.e(MainActivity.APP_TAG, "DataEntryFragment::getFirstNumber: Error, Value parse failed");
            return 0;
        }
    }

    public double getSecondNumber() {
        try {
            return Double.parseDouble(this._second.getText().toString());
        }
        catch (Exception ex) {
            Log.e(MainActivity.APP_TAG, "DataEntryFragment::getSecondNumber: Error, Value parse failed");
            return 0;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);

        // save references to the two numeric input fields
        _first = (EditText)theView.findViewById(R.id.editNumber1);
        _second = (EditText)theView.findViewById(R.id.editNumber2);
        // get a reference to the multiply button and set an onClick handler
        Button multiplyButton = (Button) theView.findViewById(R.id.buttonMultiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { multiplyButtonClicked(v); } });
        return theView;
    }

    /**
     * Multiply button onClick handler
     *
     * @param view Unused
     */
    private void multiplyButtonClicked(View view) {
        if (_listener == null) {
            return;
        }
         _listener.onMultiply();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Note: Had to also add deprecated onAttach(Activity) in my practice code
        Log.d(MainActivity.APP_TAG, "DataEntryFragment: onAttach(context) called");
        if (context instanceof MultiplyListener) {
            _listener = (MultiplyListener)context;
        }
        else {
            Log.e(MainActivity.APP_TAG, "DataEntryFragment::onAttach(context): Error, context is not MultiplyListener");
        }
    }
}
