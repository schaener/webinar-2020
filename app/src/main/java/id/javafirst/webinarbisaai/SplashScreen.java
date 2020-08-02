package id.javafirst.webinarbisaai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import id.javafirst.webinarbisaai.Main.MainActivity;
import id.javafirst.webinarbisaai.Login.LoginActivity;
import id.javafirst.webinarbisaai.Utils.SharedPrefManager;

import static id.javafirst.webinarbisaai.Utils.SharedPrefManager.SP_USERNAME;

public class SplashScreen extends AppCompatActivity {
    SharedPrefManager sharedPrefManager;
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPrefManager = new SharedPrefManager(this);
        shared = getSharedPreferences("spWebinar", MODE_PRIVATE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                if (!shared.getString(SP_USERNAME,"").isEmpty()

                ){
                    Intent home=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(home);
                    finish();
                }
                else {
                    Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        }, 3000);
    }



}