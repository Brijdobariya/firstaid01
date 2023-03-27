package com.example.demov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class emergency extends AppCompatActivity {
    TextView textview1;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        textView3 = findViewById(R.id.textView7);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW",
                Uri.parse("https://wa.me/+919313862700"));
                startActivity(viewIntent);
            }
        });
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent viewIntent = new Intent("android.intent.action.VIEW",
//                        Uri.parse("https://wa.me/+919313862700"));
//                startActivity(viewIntent);
//            }
//        });

        textview1 = findViewById(R.id.textView5);
        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textview1.getId() == R.id.textView5){
                    Intent callingIntent = new Intent(Intent.ACTION_DIAL);
                    callingIntent.setData(Uri.parse("tel:+919313862700"));
                    startActivity(callingIntent);
                }
            }
        });
        textView2 = findViewById(R.id.textView6);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView2.getId() == R.id.textView6){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","9313862700",null));
                    intent.putExtra("sms_body","Please help me, I am in danger");
                    startActivity(intent);
                }
            }
        });
    }
}