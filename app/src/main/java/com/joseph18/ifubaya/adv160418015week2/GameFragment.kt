package com.joseph18.ifubaya.adv160418015week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*

class GameFragment : Fragment() {

    var num1: Int = 0
    var num2: Int = 0

    fun RefreshQuestion(min:Int=0, max:Int=100) {
        num1 = (100*Math.random()).toInt()
        num2 = (100*Math.random()).toInt()

        txtNum1.text = num1.toString()
        txtNum2.text = num2.toString()
    }

    var score:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }

        RefreshQuestion()
        score = 0

        btnSubmit.setOnClickListener() {
            if (txtAnswer.text.toString().isNotBlank()) {
                val answer = txtAnswer.text.toString().toInt()
                val corr = num1 + num2
                val isCorrect:Boolean = (answer == corr)
                if (isCorrect) {
                    score += 1
                    RefreshQuestion()
                }
                else {
                    val action = GameFragmentDirections.actionEndFragment(playerScore = score)
                    Navigation.findNavController(it).navigate(action)
                }
                txtAnswer.text = null
            }
        }

        btnBack.setOnClickListener() {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}