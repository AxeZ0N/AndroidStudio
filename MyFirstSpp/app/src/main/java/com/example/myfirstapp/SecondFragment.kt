package com.example.myfirstapp

import Science_Words
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        view.findViewById<Button>(R.id.rerun_button).setOnClickListener{
            changeText(view)
        }

    }

    private fun changeText(view: View) {
        val textFieldView = view.findViewById<TextView>(R.id.textView_random)

        val myToast = Toast.makeText(
            context, "SciWords before", Toast.LENGTH_SHORT
        )
        myToast.show()

        val sci: Science_Words = Science_Words(
            prefixFile = "C:\\Users\\reisb\\AndroidStudioProjects\\MyFirstSpp\\app\\src\\main\\java\\com\\example\\myfirstapp\\prefix.txt",
            midfixFile = "C:\\Users\\reisb\\AndroidStudioProjects\\MyFirstSpp\\app\\src\\main\\java\\com\\example\\myfirstapp\\midfix.txt",
            suffixFile = "C:\\Users\\reisb\\AndroidStudioProjects\\MyFirstSpp\\app\\src\\main\\java\\com\\example\\myfirstapp\\suffix.txt"
        )

        val sciWords = sci.generate()

        textFieldView.text = sciWords

    }

}