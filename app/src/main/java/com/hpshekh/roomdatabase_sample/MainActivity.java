package com.hpshekh.roomdatabase_sample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hpshekh.roomdatabase_sample.adapter.ContactRVAdapter;
import com.hpshekh.roomdatabase_sample.model.Contact;
import com.hpshekh.roomdatabase_sample.viewModel.ContactViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "hpTag";
    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    private ContactViewModel contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactRVAdapter adapter = new ContactRVAdapter(this);
        recyclerView.setAdapter(adapter);

        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);

        contactViewModel.getContactList().observe(this, contacts -> {
            adapter.UpdateList(contacts);
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
        startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);
    }

    public void DeleteContact(int id) {
        contactViewModel.delete(id);
    }

    public void UpdateContact(Contact contact) {
        contactViewModel.update(contact);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_CONTACT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Contact contact = new Contact();
            contact.setName(bundle.getString("NAME"));
            contact.setMobile(bundle.getString("MOBILE"));
            contactViewModel.insert(contact);
        } else {
            Toast.makeText(this, "Contact not saved", Toast.LENGTH_SHORT).show();
        }
    }
}