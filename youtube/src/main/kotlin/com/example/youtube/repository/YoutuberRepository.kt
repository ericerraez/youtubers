package com.example.youtube.repository

import com.example.youtube.model.Youtuber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface YoutuberRepository: JpaRepository<Youtuber, Long> {
    fun findById(id: Long?):Youtuber?
}