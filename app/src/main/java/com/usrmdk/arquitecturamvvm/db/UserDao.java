package com.usrmdk.arquitecturamvvm.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.usrmdk.arquitecturamvvm.model.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(User user);

    @Query("SELECT * FROM user WHERE login = :login")
    public LiveData<User> findByLogin(String login);

}
