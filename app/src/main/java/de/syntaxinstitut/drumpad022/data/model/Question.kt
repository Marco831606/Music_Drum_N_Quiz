package de.syntaxinstitut.drumpad022.data.model

import com.squareup.moshi.Json

data class Question(
    @Json(name = "id")
    val id: String,
    @Json(name = "correctAnswer")
    val correctAnswer: String,
    @Json(name = "question")
    val question: String,
    @Json(name = "incorrectAnswers")
    val incorrectAnswers: List<String>
)