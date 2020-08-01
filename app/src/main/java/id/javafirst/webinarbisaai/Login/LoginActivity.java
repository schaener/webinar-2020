package id.javafirst.webinarbisaai.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.javafirst.webinarbisaai.Home.HomeActivity;
import id.javafirst.webinarbisaai.R;
import id.javafirst.webinarbisaai.Utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {
    AppCompatEditText username, password;
    CardView loginButton;
    SharedPrefManager sharedPrefManager;
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefManager = new SharedPrefManager(this);
        shared = getSharedPreferences("spWebinar", MODE_PRIVATE);
        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        loginButton = findViewById(R.id.cvLogin);
        handleLogin();
    }
    public void handleLogin(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //auth
                if (username.getText().toString().isEmpty()){
                    username.setError(getString(R.string.usernameTxtError));
                }
                else if (password.getText().toString().isEmpty()){
                    password.setError(getString(R.string.passwordTxtError));
                }
                else {
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME,
                            username.getText().toString());
                    Toast.makeText(getApplicationContext(),getString(R.string.welcomeTxt)+
                            username.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent moveAct = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(moveAct);
                    finish();
                }
            }
        });

    }
}