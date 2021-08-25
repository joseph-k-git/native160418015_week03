package com.joseph18.ifubaya.adv160418015week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_end.*
import kotlinx.android.synthetic.main.fragment_game.*

class EndFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val playerScore = EndFragmentArgs.fromBundle(requireArguments()).playerScore
            txtScore.text = playerScore.toString()
        }

        btnMainScreen.setOnClickListener() {
            val action = EndFragmentDirections.actionEndFragmentToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}