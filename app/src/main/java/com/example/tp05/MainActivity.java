package com.example.tp05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textViewChild;

    protected AppTP05 myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewChild = findViewById(R.id.txtChildReturn);

        this.myApp = (AppTP05) getApplication();
        this.myApp.objetPersonne = new Personne("John", "Doe");
    }

    ActivityResultLauncher<Intent> myActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent myIntent = result.getData();
                        String myString = myIntent.getStringExtra("valRenvoyee");
                        textViewChild.setText(MainActivity.this.myApp.objetPersonne.getFirstName() + " " + MainActivity.this.myApp.objetPersonne.getLastName());
                        Toast.makeText(MainActivity.this, "OK retournée de l'activité fille !", Toast.LENGTH_LONG).show();
                    }
                }
            });

    public void onClick_btnSend(View v){
        String lastName = ((EditText)findViewById(R.id.edtLastName)).getText().toString();
        String firstName = ((EditText)findViewById(R.id.edtFirstName)).getText().toString();

        this.myApp.objetPersonne.setFirstName(firstName);
        this.myApp.objetPersonne.setLastName(lastName);

        Intent intent = new Intent(this, ChildActivity.class);
        myActivityResultLauncher.launch(intent);
    }
}