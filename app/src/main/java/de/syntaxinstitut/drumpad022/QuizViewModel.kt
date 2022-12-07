package de.syntaxinstitut.drumpad022

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drumpad022.data.Repository
import com.example.drumpad022.data.remote.QuizApi
import de.syntaxinstitut.drumpad022.data.model.Question

import kotlinx.coroutines.launch


const val TAG = "QuizViewModel"


class QuizViewModel : ViewModel() {

    private val repository = Repository(QuizApi)
    private val list = repository.question

    var score = 0
    var lostGame = MutableLiveData<Boolean>(false)
    var wonGame = MutableLiveData<Boolean>(false)
    val question: LiveData<Question> = repository.question


    init {
        loadData()
    }


    private fun loadData() {
        viewModelScope.launch {
            repository.getQuestion()
        }
    }


    fun checkAnswer(answer: String) {
        if (answer == question.value?.correctAnswer) {
            score += 100


            loadData()

        } else {
            lostGame.value = true

        }
    }


    fun restartGame() {
        score = 0

        wonGame.value = false

        lostGame.value = false


    }
}



