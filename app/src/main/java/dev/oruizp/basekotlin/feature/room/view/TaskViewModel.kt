package dev.oruizp.basekotlin.feature.room.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import dev.oruizp.basekotlin.feature.room.model.db.TaskEntity
import dev.oruizp.basekotlin.feature.room.model.repository.TaskRepository
import java.util.*

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskRepository: TaskRepository = TaskRepository(application)

    fun getTasks(): LiveData<List<TaskEntity>>? = taskRepository.getTasks()

    fun getTask(id: Int): LiveData<TaskEntity>? = taskRepository.getTaskById(id)

    fun inserTask(description: String, priority: Int, date: Date) {
        val taskEntity = TaskEntity(description, priority, date)
        taskRepository.inserTask(taskEntity)
    }

    fun updateTask(id: Int, description: String, priority: Int, date: Date) {
        val taskEntity = TaskEntity(description, priority, date)
        taskEntity.id = id
    }
}