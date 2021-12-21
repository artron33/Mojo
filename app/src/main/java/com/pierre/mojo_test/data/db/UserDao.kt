package com.pierre.mojo_test.data.db

import androidx.room.*
import com.pierre.mojo_test.data.service.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): User?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(user: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: List<User>)

    @Delete
    fun delete(user: User)
}
