package dev.oruizp.basekotlin.feature.room.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dev.oruizp.basekotlin.R
import dev.oruizp.basekotlin.feature.room.model.db.TaskAppDataBase
import kotlinx.android.synthetic.main.activity_task.*

class TaskActivity : AppCompatActivity(), TaskItemClickListener {

    val EXTRA_TASK_ID = "extraTaskId"
    private val newTaskId = 0
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        setUpRecyclerView()
        setUpDb()
        setUpViewModel()
        setUpView()
    }

    override fun onItemClickListener(itemId: Int) {
        launchDetailActivity(itemId)
    }

    private fun setUpView() {
        fab.setOnClickListener {
            launchDetailActivity(0)
        }
    }

    private fun setUpViewModel() {
        val taskViewModel = ViewModelProviders.of(this)
            .get(TaskViewModel::class.java)
        taskViewModel.getTasks()?.observe(this, Observer {
            (recyclerViewTasks.adapter as TaskAdapter).itemList = it
        })
    }

    private fun setUpDb() {
        TaskAppDataBase.getInstance(applicationContext)
    }

    private fun setUpRecyclerView() {
        taskAdapter = TaskAdapter(this)
        recyclerViewTasks.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = taskAdapter
        }
    }

    private fun launchDetailActivity(id: Int) {
        val intent = Intent(this, TaskDetailActivity::class.java)
        intent.putExtra(EXTRA_TASK_ID, id)
        startActivity(intent)
    }
}
