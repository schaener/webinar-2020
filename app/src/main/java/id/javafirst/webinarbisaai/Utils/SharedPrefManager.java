package id.javafirst.webinarbisaai.Utils;

import android.content.Context;

public class SharedPrefManager {
    public static final String SP_App = "spWebinar";

    public static final String SP_USERNAME = "spUsername";
    static android.content.SharedPreferences sp;
    android.content.SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp  = context.getSharedPreferences(SP_App,Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }
    public void saveSPString(String keySP , String value){
        spEditor.putString(keySP , value);
        spEditor.commit();
    }

    public static String getSpUsername() {
        return SP_USERNAME;
    }

}
