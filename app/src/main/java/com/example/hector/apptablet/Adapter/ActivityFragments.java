package com.example.hector.apptablet.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.hector.apptablet.R;

import Utils.PreferencesManager;


public class ActivityFragments extends Activity implements View.OnClickListener {

    Button btnFrag1;
    Button btnFrag2;
    Button btnLogout;
    private PreferencesManager preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_fragments);
        preferences = new PreferencesManager(this);
        mFindView();

        btnFrag1.setOnClickListener(this);
        btnFrag2.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

    }

    private void mFindView() {

        btnFrag1 = (Button) findViewById(R.id.btnFragment1);
        btnFrag2 = (Button) findViewById(R.id.btnFragment2);
        btnLogout = (Button) findViewById(R.id.btnLogout);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fragments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        /*Fragment fr;
        if (view.getId() == R.id.btnFragment1) {
            fr = new FragmentOne();
        } else {

            fr = new FragmentTwo();
        }

        FragmentManager frmManager = getFragmentManager();
        FragmentTransaction frmTransaction = frmManager.beginTransaction();
        frmTransaction.replace(R.id.fragmento1, fr);
        frmTransaction.commit();*/

        if (view.getId() == R.id.btnLogout) {
            preferences.Logout();
            Intent i = new Intent(getApplicationContext(), MyActivity.class);
            startActivity(i);
            finish();
        }
    }
}

