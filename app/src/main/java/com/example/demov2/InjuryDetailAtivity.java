package com.example.demov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class InjuryDetailAtivity extends AppCompatActivity {

    int InjuryId;
    DatabaseHandler databaseHandler;
    InjuryModel injuryModel;
    TextView txtBodyPart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_detail_ativity);

        initialize();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            InjuryId = extras.getInt("InjuryId");
            // and get whatever type user account id is
        }

        databaseHandler = new DatabaseHandler(this);

        injuryModel = databaseHandler.getInjury(InjuryId);

//        Log.v("DS>>>",""+injuryModel.getBody_part());
          Log.v("DS>>>",""+injuryModel.getInjury());
          txtBodyPart.setText(injuryModel.getInjury());

//        txtBodyPart.setText(injuryModel.getBody_part());
    }

    private void initialize() {
        txtBodyPart = findViewById(R.id.txtBodyPart);

    }
}