package de.syntaxinstitut.drumpad022

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.drumpad022.data.QuizRepository
import com.example.drumpad022.data.mode.Question



class MainViewModel : ViewModel() {

    private val repository = QuizRepository()

    private val list = repository.loadQuestion()

    private var _questionIndex = 0
    val questionIndex: Int
        get() = _questionIndex

    val size = list.size



    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _gameEnd = MutableLiveData<Boolean>(false)
    val gameEnd: LiveData<Boolean>
        get() = _gameEnd

    init {
        _question.value = list[questionIndex]

    }



    fun checkAnswer(answer: Int) {
        if (answer == _question.value?.rightAnswer) {
            nextQuestion()
        } else {
            restartGame()
        }
    }

    private fun nextQuestion() {
        _questionIndex++

        if (_questionIndex < size) {
            _question.value = list[_questionIndex]
        } else {
            _gameEnd.value = true
        }
    }

    fun restartGame() {
        _questionIndex = 0
        _question.value = list[_questionIndex]
        _gameEnd.value = false
    }
}