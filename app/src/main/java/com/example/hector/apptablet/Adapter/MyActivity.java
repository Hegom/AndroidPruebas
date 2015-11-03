package com.example.hector.apptablet.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hector.apptablet.R;

import java.util.regex.Pattern;

import Utils.PreferencesManager;


public class MyActivity extends Activity implements View.OnClickListener {


    private PreferencesManager preferences;

    private final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private Button btnRegister;

    private Button btnLogin;
    private EditText etLogin;
    private ImageView imgView;
    private CheckBox cbChangeImage;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        preferences = new PreferencesManager(this);
        if(preferences.checkLogin())
        {

            Intent i = new Intent(getApplicationContext(), ActivityFragments.class);
            startActivity(i);
        }

        mFindView();
        btnRegister.setOnClickListener(this);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    private void mFindView() {
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        etLogin = (EditText) findViewById(R.id.etUser);
        imgView = (ImageView) findViewById(R.id.imgView);
        cbChangeImage = (CheckBox) findViewById(R.id.cbChangeImage);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                Intent i = new Intent(this, RegisterActivity.class);
                i.putExtra("clave", "llegò algo");
                i.putExtra("login", etLogin.getText().toString());
                startActivity(i);
                break;
            case R.id.btnLogin:
                String userText = etLogin.getText().toString();
                String passText = etLogin.getText().toString();

                if (userText != "" && userText.length() != 0) {
                    if (userText.equals("hegom")) {
                        Log.i("tag", "usuario hegom correcto");
                    } else {
                        Log.i("tag", "usuario hegom incorrecto");
                    }
                }

                preferences.createUser(userText, passText);

                if(preferences.checkLogin())
                {
                    Intent i2 = new Intent(getApplicationContext(), ActivityFragments.class);
                    startActivity(i2);
                    finish();
                }

                break;
        }
    }
}
