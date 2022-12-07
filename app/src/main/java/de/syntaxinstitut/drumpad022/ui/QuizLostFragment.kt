package de.syntaxinstitut.drumpad022.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.drumpad022.QuizViewModel
import de.syntaxinstitut.drumpad022.R
import de.syntaxinstitut.drumpad022.databinding.FragmentQuizGameBinding
import de.syntaxinstitut.drumpad022.databinding.FragmentWrongAnswerBinding


class QuizLostFragment : Fragment() {

    private val viewModel: QuizViewModel by activityViewModels()
    lateinit var binding: FragmentWrongAnswerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWrongAnswerBinding.inflate(inflater)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtScore.text = viewModel.score.toString()


        binding.btnTryAgain.setOnClickListener {
            viewModel.restartGame()
            findNavController()
                .navigate(QuizLostFragmentDirections.actionQuizLostFragmentToQuizGameFragment())
        }

    }
}









