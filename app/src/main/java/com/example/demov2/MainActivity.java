
package com.example.demov2;

import static com.example.demov2.R.drawable.sideicon2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    ImageButton callbtn;
//    ImageButton sms;
    DatabaseHelper dbhelper;
    DatabaseHandler databaseHandler;
    SQLiteDatabase db;
    AppCompatButton btnShowAll;
    TextView txtHead;
    TextView txtHead2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        callbtn = findViewById(R.id.imageButton);
//        callbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent callingIntent = new Intent(Intent.ACTION_DIAL);
//                callingIntent.setData(Uri.parse("tel:+919313862700"));
//                startActivity(callingIntent);
//            }
//        });

//        sms = findViewById(R.id.imageButton2);
//        sms.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","9313862700",null));
//                intent.putExtra("sms_body","Please help me, I am in danger");
//                startActivity(intent);
//            }
//        });


        btnShowAll = findViewById(R.id.btnShowAll);
        txtHead2 = findViewById(R.id.txthead2);
        txtHead = findViewById(R.id.txthead);
        btnShowAll.setOnClickListener(this);
        txtHead2.setOnClickListener(this);
        txtHead.setOnClickListener(this);
        if(checkAndRequestPermissions(MainActivity.this)){

            dbhelper = new DatabaseHelper(getApplicationContext());
            databaseHandler = new DatabaseHandler(MainActivity.this);

//            if(databaseHandler.getContactsCount()==0) {
                //add the values here first column is  id, then bodypart, then subbody part then injury and then description

                // hands -> finger

                databaseHandler.addInjury(new InjuryModel(1, "Hands", "knuckles", "burns ", "Des", R.drawable.sideicon1));
                databaseHandler.addInjury(new InjuryModel(2, "Hands", "Finger", "Burns", "Des", sideicon2));
                databaseHandler.addInjury(new InjuryModel(3, "Hands", "Forearm", "Cut", "Des", R.drawable.sideicon3));
                databaseHandler.addInjury(new InjuryModel(4, "Hands", "Forearm", "Fracture", "Des",R.drawable.sideicon4));
                databaseHandler.addInjury(new InjuryModel(5, "Hands", "Fingers", "Crushed/Smashed finger", "Des", R.drawable.sideicon5));

//                }
                // hands-> knuckles
//                databaseHandler.addInjury(new InjuryModel(1, "Hands","knuckles","Burns","Des"));
//                databaseHandler.addInjury(new InjuryModel(1, "Hands","knuckles","Strains","Des"));
//                databaseHandler.addInjury(new InjuryModel(1, "Hands","knuckles","Sprains","Des"));
//                databaseHandler.addInjury(new InjuryModel(1, "Hands","knuckles","","Des"));
//                databaseHandler.addInjury(new InjuryModel(2, "Hands","Fin","PQR","LMN"));
//                databaseHandler.addInjury(new InjuryModel(3, "ABC","XYZ","PQR","LMN"));
//                databaseHandler.addInjury(new InjuryModel(4, "ABC","XYZ","PQR","LMN"));


            db = dbhelper.getWritableDatabase();

           /* btnShowAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(MainActivity.this, InjuryListActivity.class);
                    startActivity(i);
                    finish();
                }
            });*/



            /*dbhelper = new DatabaseHelper(getApplicationContext());

            db = dbhelper.getWritableDatabase();
            try {
                dbhelper.createDatabase();
                dbhelper.openDatabase();

            Cursor cur;
            cur = db.rawQuery("select * from user_details", null);

            if (cur.moveToFirst()) {
                do {
                    Log.v("DS>>",""+cur.getColumnIndex("first_name")+" "+cur.getColumnIndex("last_name"));

                } while (cur.moveToNext());


            }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
           /* InputStream is = null;
            String sql= null;
            try {
                is = getResources().getAssets().open("sample.sql");
                sql = convertStreamToString(is);
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            /*try {
                sql = convertStreamToString(is);
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            /*SQLiteDatabase db;
            db = openOrCreateDatabase("MyDatabase.db", Context.MODE_PRIVATE, null );
            db.execSQL(sql);*/
        }


    }

    public static String convertStreamToString(InputStream is)
            throws IOException {
        Writer writer = new StringWriter();
        char[] buffer = new char[2048];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is,
                    "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            //is.close();
        }
        String text = writer.toString();
        return text;
    }

    public static boolean checkAndRequestPermissions(final Activity context) {
        int WExtstorePermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int cameraPermission = ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (WExtstorePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded
                    .add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(context, listPermissionsNeeded
                            .toArray(new String[listPermissionsNeeded.size()]),
                    1);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(),
                                    "FlagUp Requires Access to Camara.", Toast.LENGTH_SHORT)
                            .show();
                } else if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(),
                            "FlagUp Requires Access to Your Storage.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //chooseImage(MainActivity.this);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnShowAll){
            Log.v("DS>>>","I am here");
            Intent i = new Intent(MainActivity.this, InjuryListActivity.class);
            startActivity(i);
//            finish();
        }

        if(v.getId() == R.id.txthead){
            Intent i = new Intent(MainActivity.this, InjuryListActivity.class);
            i.putExtra("BodyPart", "Hands");
            startActivity(i);
        }

        if(v.getId() == R.id.txthead2){
            Intent i = new Intent(MainActivity.this, InjuryListActivity.class);
            i.putExtra("BodyPart", "Leg");
            startActivity(i);
        }
        if(v.getId() == R.id.txthead4){
            Intent i = new Intent(MainActivity.this, InjuryListActivity.class);
            i.putExtra("BodyPart", "Hand");
            startActivity(i);
        }
        if(v.getId() == R.id.txthead2){
            Intent i = new Intent(MainActivity.this, InjuryListActivity.class);
            i.putExtra("BodyPart", "Heart");
            startActivity(i);
        }
    }

   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }*/
}