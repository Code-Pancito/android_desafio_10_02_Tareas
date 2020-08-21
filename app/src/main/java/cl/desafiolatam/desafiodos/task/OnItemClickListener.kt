package cl.desafiolatam.desafiodos.task

import cl.desafiolatam.desafiodos.orm.TaskEntity

interface OnItemClickListener {
    fun onItemClick(taskItem:TaskEntity)
}