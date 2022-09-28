package com.hpshekh.roomdatabase_sample.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hpshekh.roomdatabase_sample.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    //"ORDER BY id ASC" - sort the result in ascending order by id
    //"ORDER BY id DESC" - sort the result in descending order by id
    @Query("SELECT * FROM contact_table ORDER BY id ASC")
    LiveData<List<Contact>> getContactsList();

    @Insert
    void insert(Contact contact);

    @Query("DELETE FROM contact_table WHERE id=:id")
    void delete(int id);

    @Update
    void update(Contact contact);
}
