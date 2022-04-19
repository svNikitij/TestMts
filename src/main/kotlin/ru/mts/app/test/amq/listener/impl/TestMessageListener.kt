package ru.mts.app.test.amq.listener.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.mts.app.test.amq.listener.EventListener
import ru.mts.app.test.amq.processor.model.Message

@Service
class TestMessageListener : EventListener<Message, Message> {
     private val logger by lazy { LoggerFactory.getLogger(TestMessageListener::class.java) }

    override fun onEvent(message: Message): Message {
        val newMessage = Message("listener", "${message.value} test!")
        logger.info("Сообщение $message изменено и перенаправленно. Новое состояние $newMessage")
        return newMessage
    }
}