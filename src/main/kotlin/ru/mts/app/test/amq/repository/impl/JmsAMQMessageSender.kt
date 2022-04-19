package ru.mts.app.test.amq.repository.impl

import com.google.gson.Gson
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component
import ru.mts.app.test.amq.processor.model.Message
import ru.mts.app.test.amq.repository.AMQMessageSender


@Component
class JmsAMQMessageSender(private val jmsTemplate: JmsTemplate) : AMQMessageSender {
    override fun sendMessage(queueName: String, message: String) {
        val amqMessage = Message("api", message)
        jmsTemplate.send(queueName) { session -> session.createTextMessage(Gson().toJson(amqMessage)) }
    }
}