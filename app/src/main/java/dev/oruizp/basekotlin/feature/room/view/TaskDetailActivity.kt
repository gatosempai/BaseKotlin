package dev.oruizp.basekotlin.feature.room.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.oruizp.basekotlin.R

class TaskDetailActivity : AppCompatActivity() {

    // Extra for the task ID to be received in the intent
    val EXTRA_TASK_ID = "extraTaskId"
    // Extra for the task ID to be received after rotation
    val INSTANCE_TASK_ID = "instanceTaskId"
    // Constants for priority
    val PRIORITY_HIGH = 1
    val PRIORITY_MEDIUM = 2
    val PRIORITY_LOW = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)
    }
}
