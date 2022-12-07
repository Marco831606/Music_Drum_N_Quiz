package com.example.drumpad022.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.drumpad022.QuizViewModel
import de.syntaxinstitut.drumpad022.data.model.Question
import de.syntaxinstitut.drumpad022.databinding.FragmentQuizGameBinding


class QuizGameFragment : Fragment() {

    private lateinit var binding: FragmentQuizGameBinding
    private val viewModel: QuizViewModel by activityViewModels()




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

        viewModel.lostGame.observe(
            viewLifecycleOwner, Observer {
                if (it) {
                    findNavController().navigate(QuizGameFragmentDirections.actionQuizGameFragmentToQuizLostFragment())
                }
            }
        )

        viewModel.wonGame.observe(
            viewLifecycleOwner, Observer {
                if (it) {
                    findNavController().navigate(QuizGameFragmentDirections.actionQuizGameFragmentToQuizWonFragment())
                }
            }
        )

        viewModel.question.observe(
            viewLifecycleOwner,
            Observer {
                val questionList = mutableListOf<String>(it.correctAnswer)
                questionList.addAll(it.incorrectAnswers)
                questionList.shuffle()
                binding.questionText.text = it.question.toString()
                binding.answerButton1.text = questionList[0].toString()
                binding.answerButton2.text = questionList[1].toString()
                binding.answerButton3.text = questionList[2].toString()
                binding.answerButton4.text = questionList[3].toString()




            }
        )

        binding.answerButton1.setOnClickListener {
            viewModel.checkAnswer(binding.answerButton1.text.toString())
        }
        binding.answerButton2.setOnClickListener {
            viewModel.checkAnswer(binding.answerButton2.text.toString())
        }
        binding.answerButton3.setOnClickListener {
            viewModel.checkAnswer(binding.answerButton3.text.toString())
        }
        binding.answerButton4.setOnClickListener {
            viewModel.checkAnswer(binding.answerButton4.text.toString())
        }
    }
}
