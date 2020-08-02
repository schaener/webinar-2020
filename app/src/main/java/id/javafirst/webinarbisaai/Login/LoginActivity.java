package id.javafirst.webinarbisaai.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import id.javafirst.webinarbisaai.Main.MainActivity;
import id.javafirst.webinarbisaai.R;


public class LoginActivity extends AppCompatActivity {
    AppCompatEditText username, password;
    CardView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        loginButton = findViewById(R.id.cvLogin);
        handleLogin();
    }
    public void handleLogin(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty()){
                    username.setError(getString(R.string.usernameTxtError));
                }
                else if (password.getText().toString().isEmpty()){
                    password.setError(getString(R.string.passwordTxtError));
                }
                else {
                    Toast.makeText(getApplicationContext(),getString(R.string.welcomeTxt)+
                            username.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent moveAct = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(moveAct);
                    finish();
                }
            }
        });

    }
}