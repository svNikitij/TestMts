package ru.mts.app.test.amq.repository

interface AMQMessageSender {
    fun sendMessage(queueName: String, message: String)
}