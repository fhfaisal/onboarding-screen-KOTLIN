package com.example.onboarding.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.onboarding.R

class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_third_screen, container, false)

        val finished: Button =view.findViewById(R.id.splashFinished)

        finished.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            onBoardingFinished()
        }
        return view
    }
    private fun onBoardingFinished(){
        val sharePref = requireActivity().getSharedPreferences("OnBoarding",Context.MODE_PRIVATE)
        val editor =sharePref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()

    }
}