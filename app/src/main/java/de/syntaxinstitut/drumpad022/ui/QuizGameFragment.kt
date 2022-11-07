package com.example.drumpad022.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.drumpad022.MainViewModel
import de.syntaxinstitut.drumpad022.R
import de.syntaxinstitut.drumpad022.databinding.FragmentQuizGameBinding


class QuizGameFragment : Fragment() {

      private val viewmodel: MainViewModel by activityViewModels()
      private lateinit var binding: FragmentQuizGameBinding

      var score = 0

      private fun getScore() {
            if (score<=3) {
                  Navigation.findNavController(view!!).navigate(R.id.action_quizFragment_to_quizWonFragment)
            }
            else{
                  Navigation.findNavController(view!!).navigate(R.id.action_quizFragment_to_quizLostFragment)
            }
      }

      override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View? {
            binding = FragmentQuizGameBinding.inflate(inflater)

            return binding.root
      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


            viewmodel.question.observe(
                  viewLifecycleOwner,
                  Observer {
                        Log.d("QuizFragment", "LiveData fired!!")
                        binding.questionText.text = it.question
                        binding.answerButton1.text = it.answerOne
                        binding.answerButton2.text = it.answerTwo
                        binding.answerButton3.text = it.answerthree
                        binding.answerButton4.text = it.answerFour
                        binding.counterText.text = "${viewmodel.questionIndex} / ${viewmodel.size}"
                  }
            )

            viewmodel.gameEnd.observe(
                  viewLifecycleOwner,
                  Observer {
                        if (it == true) {
                              findNavController()
                           //   Navigation.findNavController(it).navigate(R.id.action_quizFragment_to_quizLostFragment)
                        }
                  }
            )



            binding.answerButton1.setOnClickListener {
                  viewmodel.checkAnswer(1)
            }
            binding.answerButton2.setOnClickListener {
                  viewmodel.checkAnswer(2)
            }
            binding.answerButton3.setOnClickListener {
                  viewmodel.checkAnswer(3)
            }
            binding.answerButton4.setOnClickListener {
                  viewmodel.checkAnswer(4)
            }
      }
}


