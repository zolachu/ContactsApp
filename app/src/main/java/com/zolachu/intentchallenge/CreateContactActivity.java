package com.zolachu.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContactActivity extends AppCompatActivity {
    public final static String name = "name";
    public static final String number = "number";
    public static final String website = "website";
    public static final String location = "location";
    public static final String face = "face";

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivRed, ivGreen, ivYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);


        ivRed = findViewById(R.id.ivRed);
        ivGreen = findViewById(R.id.ivGreen);
        ivYellow = findViewById(R.id.ivYellow);


        ivRed.setOnClickListener(v -> {
            Intent intent = new Intent();

            intent.putExtra(name, etName.getText().toString());
            intent.putExtra(website, etWebsite.getText().toString());
            intent.putExtra(location, etLocation.getText().toString());
            intent.putExtra(number, etNumber.getText().toString());

            intent.putExtra(face, "red");
            setResult(RESULT_OK, intent);
            finish();
        });

        ivGreen.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(name, etName.getText().toString());
            intent.putExtra(website, etWebsite.getText().toString());
            intent.putExtra(location, etLocation.getText().toString());
            intent.putExtra(number, etNumber.getText().toString());
            intent.putExtra(face, "green");
            setResult(RESULT_OK, intent);
            finish();
        });

        ivYellow.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(name, etName.getText().toString());
            intent.putExtra(website, etWebsite.getText().toString());
            intent.putExtra(location, etLocation.getText().toString());
            intent.putExtra(number, etNumber.getText().toString());
            intent.putExtra(face, "yellow");
            setResult(RESULT_OK, intent);
            finish();
        });

    }


}