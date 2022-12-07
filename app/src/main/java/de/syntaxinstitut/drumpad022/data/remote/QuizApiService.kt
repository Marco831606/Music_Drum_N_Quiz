package com.example.drumpad022.data.remote


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntaxinstitut.drumpad022.data.model.Question
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET




const val BASE_URL = "https://the-trivia-api.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface QuizApiService {

    @GET("questions?categories=music&limit=10&region=DE&difficulty=easy")

    suspend fun getData(): List<Question>

}

object QuizApi {
    val retrofitService: QuizApiService by lazy { retrofit.create(QuizApiService::class.java) }
}
