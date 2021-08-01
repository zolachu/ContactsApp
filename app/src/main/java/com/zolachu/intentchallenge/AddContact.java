package com.zolachu.intentchallenge;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    String face = "" , name = "", number = "", website = "", location = "";

    ImageView ivFace, ivWeb, ivCall, ivLocate;
    Button btnCreate;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        btnCreate = findViewById(R.id.btnCreate);
        ivFace = findViewById(R.id.ivFace);
        ivCall = findViewById(R.id.ivCall);
        ivLocate = findViewById(R.id.ivLocate);
        ivWeb = findViewById(R.id.ivWeb);
        tvResults = findViewById(R.id.tvResults);

        ivFace.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivLocate.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);



        ivCall.setOnClickListener(v -> {
            String s = "tel:" + number;
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(s));
            startActivity(i);
        });

        ivLocate.setOnClickListener(v -> {
            String s = "geo:0,0?q=" + location;
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
            startActivity(i);
        });

        ivWeb.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            startActivity(i);
        });



        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();

                        name =  data.getStringExtra("name");
                        number = data.getStringExtra("number");
                        website = data.getStringExtra("website");
                        location = data.getStringExtra("location");
                        face = data.getStringExtra("face");

                        ivFace.setVisibility(View.VISIBLE);
                        ivWeb.setVisibility(View.VISIBLE);
                        ivLocate.setVisibility(View.VISIBLE);
                        ivCall.setVisibility(View.VISIBLE);

                        if (face.equals("red")) {
                            ivFace.setColorFilter(getResources().getColor(R.color.colorSmile));
                        } else if (face.equals("green")){
                            ivFace.setColorFilter(getResources().getColor(R.color.colorSmileGreen));
                        } else if (face.equals("yellow")) {
                            ivFace.setColorFilter(getResources().getColor(R.color.colorSmileYellow));
                        }

                        StringBuilder sb = new StringBuilder();
                        sb.append(name).append("\n");
                        sb.append(number + "\n");
                        sb.append(website + "\n");
                        sb.append(location + "\n");

                        tvResults.setText(sb);
                    }
                });


        btnCreate.setOnClickListener(v -> {
            Intent intent = new Intent(AddContact.this, CreateContactActivity.class);

            someActivityResultLauncher.launch(intent);

        });

    }
}