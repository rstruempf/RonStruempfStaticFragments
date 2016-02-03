package com.ronstruempf.ronstruempfstaticfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.MultiplyListener {
    public static final String APP_TAG = "StaticFragmentLog";

    private DataEntryFragment _dataEntryForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        FragmentManager fm = getSupportFragmentManager();
        if (fm == null) {
            Log.e(MainActivity.APP_TAG, "MainActivity::onCreate: Error, fragment manager is null");
            return;
        }
        _dataEntryForm = (DataEntryFragment)fm.findFragmentById(R.id.dataEntryFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMultiply() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm == null) {
            Log.e(MainActivity.APP_TAG, "MainActivity::onMultiply: Error, fragment manager is null");
            return;
        }
        double n1 = _dataEntryForm.getFirstNumber();
        double n2 = _dataEntryForm.getSecondNumber();
        DataDisplayFragment _display = (DataDisplayFragment)fm.findFragmentById(R.id.dataDisplayFragment);
       _display.displayProduct(n1, n2);
    }
}
