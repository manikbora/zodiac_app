package com.example.myzodiacapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myzodiacapp.R
import com.example.myzodiacapp.databinding.FragmentZodiacDetailsBinding

class ZodiacDetailsFragment : Fragment() {

    private var _binding: FragmentZodiacDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentZodiacDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val zodiacSign = ZodiacDetailsFragmentArgs.fromBundle(requireArguments()).zodiacSign
        binding.tvZodiacSignName.text = zodiacSign

        binding.btnLoveStyleDiscover.setOnClickListener {
            val action = ZodiacDetailsFragmentDirections
                .actionDetailsFragmentToLoveStyleFragment(zodiacSign)
            view.findNavController().navigate(action)
        }

        binding.btnFriendshipDiscoverMore.setOnClickListener {
            val action = ZodiacDetailsFragmentDirections
                .actionDetailsFragmentToFriendshipStyleFragment(zodiacSign)
            view.findNavController().navigate(action)
        }

        binding.btnCareerMoneySuccess.setOnClickListener {
            val action = ZodiacDetailsFragmentDirections
                .actionDetailsFragmentToCareerMoneySuccessFragment(zodiacSign)
            view.findNavController().navigate(action)
        }

        val dateRange = when(zodiacSign) {
            "Aries" -> "The RAM | Mar 21 - Apr 19"
            "Taurus" -> "Bull | Apr 20 - May 20"
            "Gemini" -> "Twins | May 21 - Jun 20"
            "Cancer" -> "Crab | Jun 21 - Jul 22"
            "Leo" -> "The Lion | Jul 23 - Aug 22"
            "Virgo" -> "The Virgin | Aug 23 - Sep 22"
            "Libra" -> "The Scales | Sep 23 - Oct 22"
            "Scorpio" -> "The Scorpion | Oct 23 - Nov 21"
            "Sagittarius" -> "The Archer | Nov 22 - Dec 21"
            "Capricorn" -> "The Goat | Dec 22 - Jan 19"
            "Aquarius" -> "Water Bearer |Jan 20 - Feb 18"
            "Pisces" -> "Fish | Feb 19 - Mar 20"
            else -> "Invalid date range"
        }

        binding.tvZodiacSignDateRange.text = dateRange

        val specialTraits = when(zodiacSign) {
            "Aries" -> "AMBITIOUS | INDEPENDENT | IMPATIENT"
            "Taurus" -> "DEPENDABLE | MUSICAL | PRACTICAL"
            "Gemini" -> "CURIOUS | AFFECTIONATE | KIND"
            "Cancer" -> "INTUITIVE | EMOTIONAL | INTELLIGENT"
            "Leo" -> "PROUD | BOLD | AMBITIOUS"
            "Virgo" -> "GRACEFUL | ORGANIZED | KIND"
            "Libra" -> "DIPLOMATIC | ARTISTIC | INTELLIGENT"
            "Scorpio" -> "SEDUCTIVE | PASSIONATE | INDEPENDENT"
            "Sagittarius" -> "ADVENTUROUS | CREATIVE | STRONG WILLED"
            "Capricorn" -> "DETAIL-ORIENTED | INTELLIGENT | HARDWORKING"
            "Aquarius" -> "IMAGINATIVE | IDEALISTIC | INTUITIVE"
            "Pisces" -> "CREATIVE | SENSITIVE | ARTISTIC"
            else -> "Invalid date range"
        }

        binding.tvZodiacSignSpecialTraits.text = specialTraits

        when(zodiacSign) {
            "Aries" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.aries)
            "Taurus" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.taurus)
            "Gemini" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.gemini)
            "Cancer" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.cancer)
            "Leo" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.leo)
            "Virgo" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.virgo)
            "Libra" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.libra)
            "Scorpio" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.scorpio)
            "Sagittarius" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.sagitarius)
            "Capricorn" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.capricorn)
            "Aquarius" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.aquarius)
            "Pisces" -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.picses)
            else -> binding.ivZodiacSignFragDetails.setImageResource(R.drawable.logo)
        }

        return view
    }

}