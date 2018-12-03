package hu.kindergartendeveloperteam.app.groupactivity.async

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Async<T> {
    fun execute(task: Task<T>, onResult: OnResult<T>) {
        GlobalScope.launch(Dispatchers.IO) {
            val result = task.work()
            withContext(Dispatchers.Main) {
                onResult.onResult(result)
            }
        }
    }
}