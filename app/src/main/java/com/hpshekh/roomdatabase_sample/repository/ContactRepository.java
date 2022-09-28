package com.hpshekh.roomdatabase_sample.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.hpshekh.roomdatabase_sample.dao.ContactDao;
import com.hpshekh.roomdatabase_sample.db.ContactDatabase;
import com.hpshekh.roomdatabase_sample.model.Contact;

import java.util.List;

public class ContactRepository {
    private ContactDao contactDao;
    private LiveData<List<Contact>> contactList;

    public ContactRepository(Application application) {
        ContactDatabase db = ContactDatabase.getInstance(application);
        contactDao = db.getContactDao();
        contactList = contactDao.getContactsList();
    }

    public LiveData<List<Contact>> getContactList() {
        return contactList;
    }

    public void insert(Contact contact) {
        ContactDatabase.databaseWriteExecutor.execute(() -> {
            contactDao.insert(contact);
        });
    }

    public void delete(int id) {
        ContactDatabase.databaseWriteExecutor.execute(() -> {
            contactDao.delete(id);
        });
    }

    public void update(Contact contact) {
        ContactDatabase.databaseWriteExecutor.execute(() -> {
            contactDao.update(contact);
        });
    }
}
