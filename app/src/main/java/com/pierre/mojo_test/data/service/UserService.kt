package com.pierre.mojo_test.data.service

import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT

@Entity(tableName = "user")
data class User(
    @ColumnInfo val name: String = "Jean",
    @ColumnInfo val position: String = "CEO",
    @ColumnInfo val location: String = "Paris",
    @ColumnInfo val pic: String = "https://ptitchevreuil.github.io/mojo/jean.jpg",

    @PrimaryKey var id: Int = 0,
    @ColumnInfo val positionInArray: Int
)

open interface UserService {

    @GET("/team.json")
    fun getUser(): List<User>


}