package com.example.youtube.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name="video")
class Video {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name= "youtuber_id")
    var youtuberId: Long? = null
    @NotBlank(message="Campo obligatorio")
    var title: String? = null
    var duration: Long? = null
}