package dev.oruizp.basekotlin.feature.room.model.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TaskEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class TaskAppDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        var instance: TaskAppDataBase? = null
        private val lock = Object()

        fun getInstance(context: Context): TaskAppDataBase? {
            if (instance == null) {
                synchronized(lock) {
                    Log.d("DB", "Creating new database instance")
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskAppDataBase::class.java,
                        "taskDB"
                    )
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}