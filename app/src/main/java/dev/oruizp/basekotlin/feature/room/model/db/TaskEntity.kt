package dev.oruizp.basekotlin.feature.room.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class TaskEntity(
    val description: String = "",
    val priority: Int = 0,
    @ColumnInfo(name = "update_at")
    var updateAt: Date
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}