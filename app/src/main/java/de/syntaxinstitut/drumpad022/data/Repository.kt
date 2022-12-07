package com.example.drumpad022.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.drumpad022.data.remote.QuizApi
import de.syntaxinstitut.drumpad022.data.model.Question


class Repository(private val api: QuizApi) {

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    suspend fun getQuestion() {
        val result = api.retrofitService.getData()
        _question.value = result.random()
        println("Debug")
    }

}
