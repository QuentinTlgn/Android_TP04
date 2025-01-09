package com.example.tp03;

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
    TextView textView;
    TextView textViewChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtResult);
        textViewChild = findViewById(R.id.txtChildReturn);
    }

    ActivityResultLauncher<Intent> myActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent myIntent = result.getData();
                        String myString = myIntent.getStringExtra("valRenvoyee");
                        textViewChild.setText("Resultat retourné par l'activité fille : " + myString);
                        Toast.makeText(MainActivity.this, "OK retournée de l'activité fille !", Toast.LENGTH_LONG).show();
                    }
                }
            });

    public void onClick_btnSend(View v){
        String lastName = ((EditText)findViewById(R.id.edtLastName)).getText().toString();
        String firstName = ((EditText)findViewById(R.id.edtFirstName)).getText().toString();

        Intent intent = new Intent(this, ChildActivity.class);
        intent.putExtra("firstName", firstName);
        intent.putExtra("lastName", lastName);
        myActivityResultLauncher.launch(intent);
    }
}