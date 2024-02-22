package ru.barsky.spring.service

import jakarta.mail.internet.InternetAddress
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailService (
    private val javaMailSender: JavaMailSender,
    @Value("\${spring.mail.sender.email}") private val senderEmail: String,
    @Value("\${spring.mail.sender.text}") private val senderText: String,
) {

    fun sendSimpleEmail(receiver: String) {
        val message = SimpleMailMessage()
        message.from = senderEmail
        message.setTo(receiver)
        message.subject = "Text Message"
        message.text = "Simple text message.\nSecond line."
        javaMailSender.send(message)
    }

    fun sendHtmlEmail(receiver: String) {
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message)
        helper.setFrom(InternetAddress(senderEmail, senderText))
        helper.setTo(receiver)
        helper.setSubject("Text Message")
        helper.setText("<p>Simple <b>Html</b> text message.<br>Second line.</p>", true)
        javaMailSender.send(message)
    }
}