package cl.desafiolatam.desafiodos.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(TaskEntity::class)], version = 1)
abstract class TasksDatabase: RoomDatabase() {
    abstract fun getTasksDAO(): TasksDAO

    companion object {
        @Volatile
        private  var INSTANCE: TasksDatabase? = null

        fun getDatabase(context: Context): TasksDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return  tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TasksDatabase::class.java,
                    "task_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}