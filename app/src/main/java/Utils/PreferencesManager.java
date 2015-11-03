package Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hector on 28/08/2014.
 */
public class PreferencesManager {

    private final static int PRIVATE_MODE = 0;
    private final static String PREF_NAME = "un_nombre_cualquiera.algo.otra_cosa";

    /**
     * creamos las constantes
     */

    private final static String KEY_IS_LOGIN = "_isUsserLoged";
    private final static String KEY_USER = "_user";
    private final static String KEY_PASS = "_pass";


    private SharedPreferences pref;
    private SharedPreferences.Editor mEditor;

    public PreferencesManager(Context context)
    {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = pref.edit();
    }


    public void createUser(String user, String pass)
    {
        mEditor.putString(KEY_USER, user);
        mEditor.putString(KEY_PASS, pass);
        mEditor.putBoolean(KEY_IS_LOGIN, true);
        mEditor.commit();
    }

    public void Logout()
    {
        mEditor.clear();
        mEditor.commit();
    }

    public boolean checkLogin(){
        return pref.getBoolean(KEY_IS_LOGIN, false);
    }
}
