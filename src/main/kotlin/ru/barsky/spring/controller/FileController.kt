package ru.barsky.spring.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/files")
class FileController {

    @RequestMapping
    fun processFile(@RequestParam file: MultipartFile): Int =
        file
            .inputStream
            .bufferedReader()
            .readLines()
            .size
}