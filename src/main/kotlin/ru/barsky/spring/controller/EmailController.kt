package ru.barsky.spring.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.barsky.spring.service.EmailService

@RestController
@RequestMapping("/emails")
class EmailController(private val emailService: EmailService) {

    @PostMapping("/simple")
    fun sendSimpleEmail(@RequestParam("email") email: String) =
        emailService.sendSimpleEmail(email)

    @PostMapping("/html")
    fun sendHtmlEmail(@RequestParam("email") email: String) =
        emailService.sendHtmlEmail(email)
}