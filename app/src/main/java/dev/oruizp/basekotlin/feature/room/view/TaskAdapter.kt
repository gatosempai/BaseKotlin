package dev.oruizp.basekotlin.feature.room.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.oruizp.basekotlin.R
import dev.oruizp.basekotlin.feature.room.model.db.TaskEntity
import kotlinx.android.synthetic.main.item_task.view.*
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(
    private val clickListener: TaskItemClickListener,
    var itemList: List<TaskEntity> = listOf()
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val dateFormatString = "dd/MM/yyyy"
    private val dateFormat: SimpleDateFormat =
        SimpleDateFormat(dateFormatString, Locale.getDefault())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TaskViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int {
        return if (itemList.isNotEmpty()) itemList.size else 0
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindView(itemList[position])
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(taskEntity: TaskEntity) {
            itemView.taskDescription.text = taskEntity.description
            itemView.taskUpdatedAt.text = dateFormat.format(taskEntity.updateAt)
            itemView.priorityTextView.text = taskEntity.priority.toString()
            itemView.setOnClickListener {
                clickListener.onItemClickListener(taskEntity.id)
            }

        }
    }
}