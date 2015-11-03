package com.example.hector.apptablet.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hector.apptablet.R;

import Utils.PreferencesManager;

/**
 * Created by hector on 19/08/2014.
 */
public class RegisterActivity extends Activity{

    private EditText etLogin;
    private EditText etPass;
    private Button btnRegister;
    private PreferencesManager preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        String s = getIntent().getStringExtra("clave");
        String usuario = getIntent().getStringExtra("login");

        Log.i("tagaaa", s);

            preferences = new PreferencesManager(this);
        mfindView();

        //etLogin.setText(usuario);

        btnRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.createUser(etLogin.getText().toString(), etPass.getText().toString());

                Intent i = new Intent(getApplicationContext(), MyActivity.class);
                startActivity(i);
            }
        });
    }

    private void mfindView(){
        etLogin = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        btnRegister = (Button) findViewById(R.id.btRegisterUser);
    }
}
