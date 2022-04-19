package ru.mts.app.test.amq.processor

import com.google.gson.Gson
import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import ru.mts.app.test.amq.listener.impl.TestMessageListener
import javax.jms.Message
import javax.jms.TextMessage

import ru.mts.app.test.amq.processor.model.Message as AMQMessage


@Component
class TestQueueMessageEventProcessor(private val testMessageListener: TestMessageListener) {
    @JmsListener(destination = "new.message.from.api")
    @SendTo("check.message")
    fun receiveMessage(message: Message): String {
        val jsonString = if (message is TextMessage) message.text else throw RuntimeException("Не удалось прочитать сообщение из очереди")

        val gson = Gson()
        val fromJsonMessage = gson.fromJson(jsonString, AMQMessage::class.java)

        return gson.toJson(testMessageListener.onEvent(fromJsonMessage))
    }
}