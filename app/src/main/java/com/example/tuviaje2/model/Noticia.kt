package com.example.tuviaje2.model

data class Noticia(
    val titulo: String,
    val descripcion: String,
    val url: String,
    val imageUrl: String // Nuevo campo para la URL de la imagen
)
