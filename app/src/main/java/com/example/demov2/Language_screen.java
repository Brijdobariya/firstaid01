package com.example.demov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Language_screen extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_screen);

        TextView text = findViewById(R.id.textView3);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getId() == R.id.textView3){
                    Intent i = new Intent(Language_screen.this, Emergency_screen.class);
                    i.putExtra("BodyPart", "Hands");
                    startActivity(i);
                }
            }
        });
    }
}