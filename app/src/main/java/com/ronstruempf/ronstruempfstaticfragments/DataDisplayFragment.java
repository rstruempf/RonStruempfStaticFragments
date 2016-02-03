package com.ronstruempf.ronstruempfstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Second {@link Fragment} for displaying product and button for sum
 */
public class DataDisplayFragment extends Fragment {

    private TextView _display;

    public interface AdditionListener {
        void onAdd();
    }

    private AdditionListener _listener;

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        _display = (TextView)theView.findViewById(R.id.displayProduct);
        // get a reference to the multiply button and set an onClick handler
        Button addButton = (Button) theView.findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { addButtonClicked(v); } });
        return theView;
    }

    /**
     * Display the product of two values in the TextView
     *
     * @param n1 First number
     * @param n2 Second number
     */
    public void displayProduct(double n1, double n2) {
        double product = n1 * n2;
        _display.setText(Double.toString(product));
    }

    /**
     * Add button onClick handler
     *
     * @param view Unused
     */
    private void addButtonClicked(View view) {
        if (_listener == null) {
            return;
        }
        _listener.onAdd();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Note: Had to also add deprecated onAttach(Activity) in my practice code
        Log.d(MainActivity.APP_TAG, "DataDisplayFragment: onAttach(context) called");
        if (context instanceof AdditionListener) {
            _listener = (AdditionListener)context;
        }
        else {
            Log.e(MainActivity.APP_TAG, "DataDisplayFragment::onAttach(context): Error, context is not AdditionListener");
        }
    }
}
