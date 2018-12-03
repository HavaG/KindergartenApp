package hu.kindergartendeveloperteam.app.groupactivity.async

interface Task<T> {
    fun work(): T
}