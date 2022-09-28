package com.hpshekh.roomdatabase_sample.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hpshekh.roomdatabase_sample.model.Contact;
import com.hpshekh.roomdatabase_sample.repository.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private ContactRepository contactRepository;
    private final LiveData<List<Contact>> contactList;


    public ContactViewModel(@NonNull Application application) {
        super(application);
        contactRepository = new ContactRepository(application);
        contactList = contactRepository.getContactList();
    }

    public LiveData<List<Contact>> getContactList() {
        return contactList;
    }

    public void insert(Contact contact) {
        contactRepository.insert(contact);
    }

    public void delete(int id) {
        contactRepository.delete(id);
    }

    public void update(Contact contact) {
        contactRepository.update(contact);
    }
}
