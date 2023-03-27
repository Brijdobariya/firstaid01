package com.example.demov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Emergency_screen extends AppCompatActivity {
    TextView textview;
    TextView textView22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_screen);

        textView22 = findViewById(R.id.textView2);
        textView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView22.getId() == R.id.textView2){
                    Intent i = new Intent(Emergency_screen.this, emergency.class);
                    i.putExtra("BodyPart", "Hands");
                    startActivity(i);
                }
            }
        });
        textview= findViewById(R.id.textView4);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textview.getId() == R.id.textView4){
                    Intent i = new Intent(Emergency_screen.this, MainActivity.class);
                    i.putExtra("BodyPart", "Hands");
                    startActivity(i);
                }
            }
        });
    }
}