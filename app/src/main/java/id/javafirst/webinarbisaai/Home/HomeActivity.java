package id.javafirst.webinarbisaai.Home;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

import id.javafirst.webinarbisaai.Home.Adapter.NationAdapter;
import id.javafirst.webinarbisaai.Home.Model.NationModel;
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
    RecyclerView nation;
    NationAdapter madapter;
    List<NationModel> listNationM = new ArrayList<>();
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
        nation = findViewById(R.id.rvNation);
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
        LinearLayoutManager llm = new LinearLayoutManager(this);
        nation.setLayoutManager(llm);
        madapter = new NationAdapter(listNationM,this);
        nation.setItemAnimator(new DefaultItemAnimator());
        nation.setAdapter(madapter);
        NationModel nationModel = new NationModel(getString(R.string.idnTxt),R.drawable.indonesia
                );
       listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.mlyTxt),R.drawable.malaysia);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.sgTxt),R.drawable.singapore);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.kmjTxt),R.drawable.kamboja);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.lsTxt),R.drawable.laos);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.phTxt),R.drawable.philipines);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.vtTxt),R.drawable.vietnam);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.thaiTxt),R.drawable.thailand);
        listNationM.add(nationModel);
        nationModel = new NationModel(getString(R.string.brnTxt),R.drawable.brunei);
        listNationM.add(nationModel);
        madapter.notifyDataSetChanged();
    }
}