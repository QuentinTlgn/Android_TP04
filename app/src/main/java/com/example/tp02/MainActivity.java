package com.example.tp02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.tp02.ChildActivity;

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

        Intent intent = new Intent(this, ChildActivity.class);
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);
        startActivity(intent);
    }
}