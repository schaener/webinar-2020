package id.javafirst.webinarbisaai.Home;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import id.javafirst.webinarbisaai.Login.LoginActivity;
import id.javafirst.webinarbisaai.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;
import static id.javafirst.webinarbisaai.Utils.SharedPrefManager.SP_USERNAME;

public class HomeActivity extends AppCompatActivity {
  RadioGroup chooseLanguage;
  TextView txtLng,txtToast,txtTotal;
  AppCompatSpinner chooseColor;
    SharedPreferences shared;
    CardView logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chooseLanguage = findViewById(R.id.rgLanguage);
        txtLng = findViewById(R.id.txtLanguage);
        chooseColor = findViewById(R.id.spColor);
        txtToast = findViewById(R.id.txtToast);
        txtTotal = findViewById(R.id.txtTotal);
        shared = getApplication().getSharedPreferences("spWebinar", MODE_PRIVATE);
        logoutButton = findViewById(R.id.cvLogout);
        // inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrayTxtColor));

        // mengeset Array Adapter tersebut ke Spinner
        chooseColor.setAdapter(adapter);
        chooseLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = chooseLanguage.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.rbInd:
                        txtLng.setText(R.string.txtIdn);

                        break;
                    case R.id.rbEng:
                        txtLng.setText(R.string.txtEng);


                        break;

                    default:
                        // Your code
                        break;
                }
            }
        });
        chooseColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {

                    txtLng.setTextColor(getResources().getColor(R.color.black));

                }
                if (position == 1) {

                    txtLng.setTextColor(getResources().getColor(R.color.red));

                }
                if (position == 2) {

                    txtLng.setTextColor(getResources().getColor(R.color.orange));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
        txtToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i ;
                txtTotal.setText("");
                for(i=1; i<=txtLng.getTextSize(); i++){//value increased by 2

                        txtTotal.append("\n" + i);


                  }
                txtTotal.append("\n" +getString(R.string.lineTotal)+(i-1));
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared.edit().clear().apply();

                Intent newIntent = new Intent(getApplicationContext(), LoginActivity.class);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
                startActivity(newIntent);
            }
        });
    }
}