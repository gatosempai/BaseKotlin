package dev.oruizp.basekotlin.feature.room.model.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM taskEntity ORDER BY priority")
    fun loadAllTask(): LiveData<List<TaskEntity>>

    @Insert
    fun insertTask(taskEntity: TaskEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(taskEntity: TaskEntity)

    @Delete
    fun deleteTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM TaskEntity WHERE id = :id ")
    fun loadTaskById(id: Int): LiveData<TaskEntity>
}