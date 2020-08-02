package id.javafirst.webinarbisaai.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.codesgood.views.JustifiedTextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;
import id.javafirst.webinarbisaai.R;
import id.javafirst.webinarbisaai.RV.RecyclerActivity;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class MainActivity extends AppCompatActivity {
    RadioGroup chooseLanguage;
    JustifiedTextView txtLng;
    TextView  txtToast, txtTotal;
    AppCompatSpinner chooseColor;
    SharedPreferences shared;
    CardView rvButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pindah Ke Halaman RecyclerView
        rvButton = findViewById(R.id.cvRecyclerView);

        //Pilih Bahasa
        chooseLanguage = findViewById(R.id.rgLanguage);
        txtLng = findViewById(R.id.txtLanguage);

        //Spinner
        chooseColor = findViewById(R.id.spColor);
        // inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.arrayTxtColor));
        // mengeset Array Adapter tersebut ke Spinner
        chooseColor.setAdapter(adapter);

        txtToast = findViewById(R.id.txtToast);
//        txtTotal = findViewById(R.id.txtTotal);
        shared = getApplication().getSharedPreferences("spWebinar", MODE_PRIVATE);

        chooseLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("WrongConstant")
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
                    txtLng.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                if (position == 1) {
                    txtLng.setTextColor(getResources().getColor(R.color.colorRed));
                }
                if (position == 2) {
                    txtLng.setTextColor(getResources().getColor(R.color.colorGreen));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i;
//                txtTotal.setText("");
                for (i = 1; i <= txtLng.getLineCount(); i++) {//value increased by 2
                    Log.d("\b"+"Baris Ke- ",String.valueOf(i));
//                    txtTotal.append("\n" + i);
                }
//                txtTotal.append("\n" + getString(R.string.lineTotal) + (i - 1));
                Toast.makeText(getApplicationContext(),"Jumlah Baris dari Teks Tersebut Adalah "+(i - 1),
                        Toast.LENGTH_SHORT).show();
            }
        });

        rvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recyclerView = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(recyclerView);
            }
        });


    }
}