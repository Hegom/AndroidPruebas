package com.example.hector.apptablet.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hector.apptablet.R;

import java.util.ArrayList;

import Utils.PreferencesManager;
import Utils.PreferencesManager2;

public class formulario_persistencia extends Activity implements  View.OnClickListener  {

    Button btnNavegar;
    EditText etCampo1;
    EditText etCampo2;
    EditText etCampo3;
    PreferencesManager2 preferencesManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_persistencia);
        preferencesManager = new PreferencesManager2(this);
        mFindView();
        btnNavegar.setOnClickListener(this);
    }

    private void mFindView()
    {
        btnNavegar = (Button) findViewById(R.id.btnNavegar);
        etCampo1 = (EditText) findViewById(R.id.etCampo1);
        etCampo2 = (EditText) findViewById(R.id.etCampo2);
        etCampo3 = (EditText) findViewById(R.id.etCampo3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.formulario_persistencia, menu);
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
    protected void onResume() {
        super.onResume();
        ArrayList<String> al = preferencesManager.getData();
        etCampo1.setText(al.get(0));
        etCampo2.setText(al.get(1));
        etCampo3.setText(al.get(2));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preferencesManager.deleteData();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnNavegar){
            preferencesManager.saveData(etCampo1.getText().toString(),etCampo2.getText().toString(), etCampo3.getText().toString() );
            Intent i = new Intent(getApplicationContext(), MyActivity.class);
            startActivity(i);
        }
    }
}
