package com.example.tp04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {

    private AppTP04 myApp;
    private EditText firstNameEditText;
    private EditText lastNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        TextView textView = findViewById(R.id.textView);
        firstNameEditText = findViewById(R.id.firstNameEditText); // Assuming you have these EditTexts in your layout
        lastNameEditText = findViewById(R.id.lastNameEditText);
        Button saveButton = findViewById(R.id.saveButton); // Assuming you have a save button

        this.myApp = (AppTP04) getApplication();

        // Display initial values
        firstNameEditText.setText(this.myApp.objetPersonne.getFirstName());
        lastNameEditText.setText(this.myApp.objetPersonne.getLastName());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update Person object with edited values
                myApp.objetPersonne.setFirstName(firstNameEditText.getText().toString());
                myApp.objetPersonne.setLastName(lastNameEditText.getText().toString());

                // Update TextView (optional)
                textView.setText("Nom : " + myApp.objetPersonne.getFirstName() + "\nPrenom : " + myApp.objetPersonne.getLastName());
            }
        });
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("valRenvoyee", "OK");
        setResult(RESULT_OK, data);
        super.finish();
    }

}