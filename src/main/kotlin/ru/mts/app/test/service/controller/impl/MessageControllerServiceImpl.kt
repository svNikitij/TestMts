package ru.mts.app.test.service.controller.impl

import org.springframework.stereotype.Service
import ru.mts.app.test.amq.repository.impl.JmsAMQMessageSender
import ru.mts.app.test.service.controller.MessageControllerService

@Service
class MessageControllerServiceImpl(private val amqMessageSender: JmsAMQMessageSender) : MessageControllerService {
    companion object {
        const val QUEUE_API = "new.message.from.api"
    }

    override fun addMessage(message: String) {
        amqMessageSender.sendMessage(QUEUE_API, message)
    }
}