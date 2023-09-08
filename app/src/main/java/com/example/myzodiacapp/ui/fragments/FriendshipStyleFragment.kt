package com.example.myzodiacapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myzodiacapp.R
import com.example.myzodiacapp.databinding.FragmentFriendshipStyleBinding

class FriendshipStyleFragment : Fragment() {

    private var _binding: FragmentFriendshipStyleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFriendshipStyleBinding.inflate(inflater, container, false)
        val view = binding.root

        when(FriendshipStyleFragmentArgs.fromBundle(requireArguments()).zodiacSign) {
            "Aries" -> binding.ivZodiacSign.setImageResource(R.drawable.aries)
            "Taurus" -> binding.ivZodiacSign.setImageResource(R.drawable.taurus)
            "Gemini" -> binding.ivZodiacSign.setImageResource(R.drawable.gemini)
            "Cancer" -> binding.ivZodiacSign.setImageResource(R.drawable.cancer)
            "Leo" -> binding.ivZodiacSign.setImageResource(R.drawable.leo)
            "Virgo" -> binding.ivZodiacSign.setImageResource(R.drawable.virgo)
            "Libra" -> binding.ivZodiacSign.setImageResource(R.drawable.libra)
            "Scorpio" -> binding.ivZodiacSign.setImageResource(R.drawable.scorpio)
            "Sagittarius" -> binding.ivZodiacSign.setImageResource(R.drawable.sagitarius)
            "Capricorn" -> binding.ivZodiacSign.setImageResource(R.drawable.capricorn)
            "Aquarius" -> binding.ivZodiacSign.setImageResource(R.drawable.aquarius)
            "Pisces" -> binding.ivZodiacSign.setImageResource(R.drawable.picses)
            else -> binding.ivZodiacSign.setImageResource(R.drawable.logo)
        }

        binding.btnHome.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_friendshipStyleFragment_to_mainFragment)
        }

        return view
    }

}