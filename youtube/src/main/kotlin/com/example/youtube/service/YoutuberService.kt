package com.example.youtube.service

import com.example.youtube.model.Youtuber
import com.example.youtube.repository.YoutuberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class YoutuberService {

    @Autowired
    lateinit var youtuberRepository: YoutuberRepository

    fun list(): List<Youtuber> {
        return youtuberRepository.findAll()
    }

    fun save(youtuber: Youtuber): Youtuber? {
        return youtuberRepository.save(youtuber)
    }

    fun update(youtuber: Youtuber): Youtuber {
        try {
            youtuberRepository.findById(youtuber.id)
                    ?: throw Exception("ID no existe")

            return youtuberRepository.save(youtuber)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(youtuber: Youtuber): Youtuber {
        try {
            val response = youtuberRepository.findById(youtuber.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                channel = youtuber.channel
            }
            return youtuberRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}