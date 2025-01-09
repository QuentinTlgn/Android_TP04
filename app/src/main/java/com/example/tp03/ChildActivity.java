package com.example.tp03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");

        textView.setText("Nom : " + lastName + "\nPrenom : " + firstName);
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("valRenvoyee", "OK");
        setResult(RESULT_OK, data);
        super.finish();
    }

}