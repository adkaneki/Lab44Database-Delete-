package my.edu.tarc.lab44database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


//TODO 4: Create a DAO interface
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAllUsers();

    @Query("SELECT * FROM user WHERE phone=:phone")
    List<User> findUserByPhone(String phone);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
