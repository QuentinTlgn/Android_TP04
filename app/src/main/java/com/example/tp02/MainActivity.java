package com.example.tp02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtResult);
    }

    public void onClick_btnSend(View v){
        String lastName = ((EditText)findViewById(R.id.edtLastName)).getText().toString();
        String firstName = ((EditText)findViewById(R.id.edtFirstName)).getText().toString();

        textView.setText("Nom: " + lastName + "\nPrenom: " + firstName);

        Toast.makeText(v.getContext(), "OK !", Toast.LENGTH_LONG).show();
    }
}