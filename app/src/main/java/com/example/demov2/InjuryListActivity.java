package com.example.demov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class InjuryListActivity extends AppCompatActivity {

    SearchView mysearch;
    ListView lv_InjurytList;
    DatabaseHandler db;
    ArrayList<InjuryModel> InjuryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_list);


        mysearch = (SearchView)findViewById(R.id.searchth);
        lv_InjurytList = findViewById(R.id.lv_InjuryList);
        InjuryList  = new ArrayList<>();
        db = new DatabaseHandler(this);

        List<InjuryModel> injuries = db.getAllInjuries();
        //List<InjuryModel> injuries = db.getInjurybyName("");


        for (InjuryModel cn : injuries) {
            /*String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " +
                    cn.get_phone_number()+ " image "+cn.getImage();*/
            InjuryList.add(new InjuryModel(cn.get_id(), cn.getBody_part(), cn.getSb_part(),
                    cn.getInjury(), cn.getContent(), cn.getImage()));
            // Writing Contacts to log
            //Log.v("Name: ", log);
        }



        CustomAdapter customAdapter = new CustomAdapter
                (InjuryListActivity.this, InjuryList);
        lv_InjurytList.setAdapter(customAdapter);

        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });

        lv_InjurytList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(InjuryListActivity.this, InjuryDetailAtivity.class);
                intent.putExtra("InjuryId", InjuryList.get(i).get_id());
                startActivity(intent);
            }
        });


    }
}