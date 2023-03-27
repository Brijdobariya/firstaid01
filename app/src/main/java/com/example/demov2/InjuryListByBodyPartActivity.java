package com.example.demov2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InjuryListByBodyPartActivity extends AppCompatActivity {

    ListView lv_InjurytList;
    DatabaseHandler db;
    ArrayList<InjuryModel> InjuryList;
    String BodyPart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_list);


        lv_InjurytList = findViewById(R.id.lv_InjuryList);
        InjuryList  = new ArrayList<>();
        db = new DatabaseHandler(this);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            BodyPart = extras.getString("BodyPart");
            // and get whatever type user account id is
        }


        List<InjuryModel> injuries = db.getInjurybyName(BodyPart);


        for (InjuryModel cn : injuries) {
            /*String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " +
                    cn.get_phone_number()+ " image "+cn.getImage();*/
            InjuryList.add(new InjuryModel(cn.get_id(), cn.getBody_part(), cn.getSb_part(),
                    cn.getInjury(), cn.getContent(), cn.getImage()));
            // Writing Contacts to log
            //Log.v("Name: ", log);
        }

        CustomAdapter customAdapter = new CustomAdapter
                (InjuryListByBodyPartActivity.this, InjuryList);
        lv_InjurytList.setAdapter(customAdapter);

        lv_InjurytList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(InjuryListByBodyPartActivity.this, InjuryDetailAtivity.class);
                intent.putExtra("InjuryId", InjuryList.get(i).get_id());
                startActivity(intent);
            }
        });


    }
}