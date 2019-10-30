package dev.oruizp.basekotlin.feature.room.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import dev.oruizp.basekotlin.feature.room.model.db.TaskAppDataBase
import dev.oruizp.basekotlin.feature.room.model.db.TaskDao
import dev.oruizp.basekotlin.feature.room.model.db.TaskEntity
import java.util.concurrent.Executors

class TaskRepository(
    context: Application
) {
    private val taskDao: TaskDao? = TaskAppDataBase.getInstance(context)?.taskDao()

    fun getTasks(): LiveData<List<TaskEntity>>? = taskDao?.loadAllTask()

    fun getTaskById(id: Int): LiveData<TaskEntity>? = taskDao?.loadTaskById(id)

    fun inserTask(taskEntity: TaskEntity) {
        Executors.newSingleThreadExecutor().execute {
            taskDao?.insertTask(taskEntity = taskEntity)
        }
    }

    fun updateTask(taskEntity: TaskEntity) {
        Executors.newSingleThreadExecutor().execute {
            taskDao?.updateTask(taskEntity = taskEntity)
        }
    }

    fun deleteTask(taskEntity: TaskEntity) {
        Executors.newSingleThreadExecutor().execute {
            taskDao?.deleteTask(taskEntity = taskEntity)
        }
    }
}