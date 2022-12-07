package de.syntaxinstitut.drumpad022.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import de.syntaxinstitut.drumpad022.R
import de.syntaxinstitut.drumpad022.databinding.FragmentLoginBinding


class LoginFragment: Fragment() {

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)
        return binding.root



    }

}