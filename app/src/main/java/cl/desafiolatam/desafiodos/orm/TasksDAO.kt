package cl.desafiolatam.desafiodos.orm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TasksDAO {

    @Query("SELECT * FROM task_list")
    fun getAllTasks(): LiveData<List<TaskEntity>>

    @Insert
    suspend fun insertTask(tasks: TaskEntity)

    @Query("DELETE FROM task_list")
    suspend fun deleteAllTasks()

    @Update
    suspend fun updateTask(task: TaskEntity)

}