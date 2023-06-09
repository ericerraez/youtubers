package com.example.youtube.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name="youtuber")

class Youtuber {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio")
    var channel: String? = null
    @Column(name= "all_videos")
    var allVideos: Double? = null
    var monetize: Boolean? = null
}