package de.syntaxinstitut.drumpad022.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import de.syntaxinstitut.drumpad022.R
import de.syntaxinstitut.drumpad022.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.btnPlay.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_quizGameFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }


}
