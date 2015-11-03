package Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by hector on 28/08/2014.
 */
public class PreferencesManager2 {

    private final static int PRIVATE_MODE = 0;
    private final static String PREF_NAME = "un_nombre_cualquiera.algo.otra_cosa";

    /**
     * creamos las constantes
     */

    private final static String KEY_CAMPO1 = "_icampo1";
    private final static String KEY_CAMPO2 = "_icampo2";
    private final static String KEY_CAMPO3 = "_icampo3";


    private SharedPreferences pref;
    private SharedPreferences.Editor mEditor;

    public PreferencesManager2(Context context)
    {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = pref.edit();
    }


    public void saveData(String c1, String c2, String c3)
    {
        mEditor.putString(KEY_CAMPO1, c1);
        mEditor.putString(KEY_CAMPO2, c2);
        mEditor.putString(KEY_CAMPO3, c3);
        mEditor.commit();
    }

    public void deleteData()
    {
        mEditor.clear();
        mEditor.commit();
    }

    public ArrayList<String> getData()
    {
        ArrayList<String> al = new ArrayList<String>();
        al.add(pref.getString(KEY_CAMPO1, ""));
        al.add(pref.getString(KEY_CAMPO2, ""));
        al.add(pref.getString(KEY_CAMPO3, ""));
        return al;
    }

}
