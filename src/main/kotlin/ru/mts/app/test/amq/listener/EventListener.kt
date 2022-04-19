package ru.mts.app.test.amq.listener

interface EventListener<T, Q> {
    fun onEvent(message: T): Q?
}