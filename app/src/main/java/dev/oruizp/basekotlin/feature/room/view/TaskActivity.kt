package dev.oruizp.basekotlin.feature.room.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.oruizp.basekotlin.R

class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        setUpRecyclerView()
        setUpDb()
        setUpViewModel()
        setUpView()
    }
}
