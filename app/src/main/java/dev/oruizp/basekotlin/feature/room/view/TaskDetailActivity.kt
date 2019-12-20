package dev.oruizp.basekotlin.feature.room.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.oruizp.basekotlin.R
import dev.oruizp.basekotlin.feature.room.model.db.TaskEntity
import kotlinx.android.synthetic.main.activity_task_detail.*
import java.util.*

class TaskDetailActivity : AppCompatActivity() {

    // Extra for the task ID to be received in the intent
    val EXTRA_TASK_ID = "extraTaskId"
    // Extra for the task ID to be received after rotation
    val INSTANCE_TASK_ID = "instanceTaskId"
    // Constants for priority
    val PRIORITY_HIGH = 1
    val PRIORITY_MEDIUM = 2
    val PRIORITY_LOW = 3
    // Constant for default task id to be used when not in update mode
    val DEFAULT_TASK_ID = 0
    var mTaskId = DEFAULT_TASK_ID

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)
        setUpViewModel()
        setUpClickListeners()
    }

    private fun setUpViewModel() {
        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        val intent: Intent? = intent
        mTaskId = intent?.getIntExtra(EXTRA_TASK_ID, DEFAULT_TASK_ID) ?: DEFAULT_TASK_ID
        if (mTaskId > 0) {
            taskViewModel.getTask(mTaskId)?.observe(this, object : Observer<TaskEntity?> {
                override fun onChanged(taskEntity: TaskEntity?) {
                    taskViewModel.getTask(mTaskId)!!.removeObserver(this)
                    populateUI(taskEntity)
                }
            })
        }
    }

    private fun setUpClickListeners() {
        saveButton.setOnClickListener {
            onSaveButtonClicked()
        }
    }

    private fun onSaveButtonClicked() {
        val description = editTextTaskDescription.text.toString()
        val priority = getPriorityFromViews()
        val date = Date()
        when (mTaskId) {
            DEFAULT_TASK_ID -> taskViewModel.inserTask(description, priority, date)
            else -> taskViewModel.updateTask(mTaskId, description, priority, date)
        }
        finish()

    }

    private fun getPriorityFromViews(): Int {
        return when (radioGroup.checkedRadioButtonId) {
            R.id.radButton1 -> PRIORITY_HIGH
            R.id.radButton2 -> PRIORITY_MEDIUM
            R.id.radButton3 -> PRIORITY_LOW
            else -> 1
        }
    }

    private fun setPriorityInViews(priority: Int?) {
        when (priority) {
            PRIORITY_HIGH -> radioGroup.check(radButton1.id)
            PRIORITY_MEDIUM -> radioGroup.check(radButton2.id)
            PRIORITY_LOW -> radioGroup.check(radButton3.id)
        }
    }

    private fun populateUI(taskEntity: TaskEntity?) {
        editTextTaskDescription.setText(taskEntity?.description)
        setPriorityInViews(taskEntity?.priority)
    }
}
