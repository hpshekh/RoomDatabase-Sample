package com.hpshekh.roomdatabase_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        EditText nameEdt = findViewById(R.id.nameEdt);
        EditText mobileEdt = findViewById(R.id.mobileEdt);
        Button saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (!nameEdt.getText().toString().isEmpty() || !mobileEdt.getText().toString().isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putString("NAME", nameEdt.getText().toString());
                bundle.putString("MOBILE", mobileEdt.getText().toString());
                replyIntent.putExtras(bundle);
                setResult(RESULT_OK, replyIntent);
            } else {
                setResult(RESULT_CANCELED, replyIntent);
            }

            finish();
        });

    }
}