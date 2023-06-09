package com.example.youtube.service

import com.example.youtube.model.Video
import com.example.youtube.repository.VideoRepository
import com.example.youtube.repository.YoutuberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class VideoService {

    @Autowired
    lateinit var videoRepository: VideoRepository

    @Autowired
    lateinit var youtuberRepository: YoutuberRepository

    @Autowired
    lateinit var youtuberService: YoutuberService

    fun list(): List<Video>{
        return videoRepository.findAll()
    }

    fun save (video: Video):Video?{
        try{
            val responseYoutuber= youtuberRepository.findById(video.youtuberId)
                    ?: throw Exception("Id no existe")

            val responseVideo = videoRepository.save(video)
            //paso adicionales antes de devlver
            //obtener el total de las amonstaciones
            var totalVideo = getTotalVideo(video.youtuberId)
            //actulizar el player
            youtuberRepository.save(responseYoutuber.apply {allVideos=totalVideo})

            return responseVideo
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }


    }

    fun update(video: Video): Video {
        try {
            videoRepository.findById(video.id)
                    ?: throw Exception("ID no existe")

            return videoRepository.save(video)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(video: Video): Video {
        try{
            val response = videoRepository.findById(video.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                duration=video.duration
            }
            return videoRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun getTotalVideo(youtuberId: Long?): Double? {
        return videoRepository.getTotalVideo(youtuberId)
    }

}