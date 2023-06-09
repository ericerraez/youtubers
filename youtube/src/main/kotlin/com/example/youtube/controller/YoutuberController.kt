package com.example.youtube.controller

import com.example.youtube.model.Youtuber
import com.example.youtube.service.YoutuberService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/youtuber")

class YoutuberController {

    @Autowired
    lateinit var youtuberService: YoutuberService

    @GetMapping
    fun list(): ResponseEntity<*> {
        return ResponseEntity(youtuberService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid youtuber: Youtuber): ResponseEntity<Youtuber> {
        return ResponseEntity(youtuberService.save(youtuber), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody youtuber: Youtuber): ResponseEntity<Youtuber> {
        return ResponseEntity(youtuberService.update(youtuber), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody youtuber: Youtuber): ResponseEntity<Youtuber> {
        return ResponseEntity(youtuberService.updateName(youtuber), HttpStatus.OK)
    }
}