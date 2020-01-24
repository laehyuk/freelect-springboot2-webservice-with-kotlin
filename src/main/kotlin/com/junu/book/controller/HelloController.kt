package com.junu.book.controller

import com.junu.book.dto.HelloResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(@RequestParam name : String, @RequestParam amount : Int) =
            ResponseEntity.ok(HelloResponseDto(name, amount))


}