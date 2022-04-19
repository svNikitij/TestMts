package ru.mts.app.test.service.controller

import org.springframework.web.bind.annotation.RequestBody
import javax.validation.constraints.NotNull

interface MessageControllerService {
    fun addMessage(@NotNull @RequestBody message: String)
}