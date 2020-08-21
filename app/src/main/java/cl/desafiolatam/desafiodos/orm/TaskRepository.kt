package cl.desafiolatam.desafiodos.orm

import androidx.lifecycle.LiveData

class TaskRepository(private var tasksDAO: TasksDAO) {

    var liveDataTaskList: LiveData<List<TaskEntity>> = tasksDAO.getAllTasks()

    suspend fun insertTask(task: TaskEntity) {
        tasksDAO.insertTask(task)
    }

    suspend fun deleteAllTasks() {
        tasksDAO.deleteAllTasks()
    }

    suspend fun updateTask(task: TaskEntity) {
        tasksDAO.updateTask(task)
    }

}