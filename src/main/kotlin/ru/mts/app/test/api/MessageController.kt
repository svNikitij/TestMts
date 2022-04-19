package ru.mts.app.test.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mts.app.test.service.controller.impl.MessageControllerServiceImpl
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/test/api/v0/action")
@Tag(name = "Message", description = "Управление сообщениями")
class MessageController(private val messageControllerService: MessageControllerServiceImpl) {
    @Operation(description = "Добавление нового сообщения")
    @PostMapping
    fun addMessage(@NotNull @RequestBody message: String) {
        messageControllerService.addMessage(message)
    }
}