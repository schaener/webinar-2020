package id.javafirst.webinarbisaai.RV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.javafirst.webinarbisaai.Login.LoginActivity;
import id.javafirst.webinarbisaai.R;
import id.javafirst.webinarbisaai.RV.Adapter.NationAdapter;
import id.javafirst.webinarbisaai.RV.Model.NationModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    SharedPreferences shared;
    CardView logoutButton;
    RecyclerView nation;
    NationAdapter madapter;
    List<NationModel> listNationM = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        shared = getApplication().getSharedPreferences("spWebinar", MODE_PRIVATE);
        logoutButton = findViewById(R.id.cvLogout);
        nation = findViewById(R.id.rvNation);

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