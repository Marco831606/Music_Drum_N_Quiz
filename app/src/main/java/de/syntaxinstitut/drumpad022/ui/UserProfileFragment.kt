package de.syntaxinstitut.drumpad022.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.drumpad022.QuizViewModel
import de.syntaxinstitut.drumpad022.R

import de.syntaxinstitut.drumpad022.databinding.FragmentUserProfileBinding


class UserProfileFragment : Fragment() {

    private val viewmodel: QuizViewModel by activityViewModels()

    lateinit var binding: FragmentUserProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile,container,false)
        binding.btnLogout.setOnClickListener {

        }

        return binding.root
    }
}