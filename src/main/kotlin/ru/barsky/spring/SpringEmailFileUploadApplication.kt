package ru.barsky.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringEmailFileUploadApplication

fun main(args: Array<String>) {
	runApplication<SpringEmailFileUploadApplication>(*args)
}
