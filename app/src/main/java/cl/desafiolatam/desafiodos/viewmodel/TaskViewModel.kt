package cl.desafiolatam.desafiodos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.desafiodos.orm.TaskEntity
import cl.desafiolatam.desafiodos.orm.TaskRepository
import cl.desafiolatam.desafiodos.orm.TasksDatabase
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val taskRepository: TaskRepository
    val allTasks: LiveData<List<TaskEntity>>

    init {
        val tasksDAO = TasksDatabase.getDatabase(application).getTasksDAO()
        taskRepository = TaskRepository(tasksDAO)
        allTasks = taskRepository.liveDataTaskList
    }

    fun insertTask(task: TaskEntity) = viewModelScope.launch {
        taskRepository.insertTask(task)
    }

    fun deleteAllTasks() = viewModelScope.launch {
        taskRepository.deleteAllTasks()
    }

    fun updateTask(task: TaskEntity) = viewModelScope.launch {
        taskRepository.updateTask(task)
    }
}