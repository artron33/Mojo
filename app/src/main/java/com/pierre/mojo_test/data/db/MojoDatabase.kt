package com.pierre.mojo_test.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pierre.mojo_test.data.service.User

@Database(entities = [User::class], version = 1)
abstract class MojoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "france-tv.db"

        @Volatile
        private var instance: MojoDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): MojoDatabase {
            return instance
                ?: run {
                    instance =
                        buildDatabase(
                            context
                        )
                    instance!!
                }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MojoDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
