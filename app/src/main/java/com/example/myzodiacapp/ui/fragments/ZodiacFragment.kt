package com.example.myzodiacapp.ui.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import com.example.myzodiacapp.R
import com.example.myzodiacapp.databinding.FragmentZodiacBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.util.Calendar
import java.util.Locale


class ZodiacFragment : Fragment() {

    private var _binding: FragmentZodiacBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentZodiacBinding.inflate(inflater, container, false)
        val view = binding.root

        val userName = ZodiacFragmentArgs.fromBundle(requireArguments()).username
        val dob = ZodiacFragmentArgs.fromBundle(requireArguments()).dob

        binding.tvUserName.text = userName
        binding.tvDOB.text = dob

        val zodiacSign = getZodiacSign(dob)
        binding.tvZodiacSign.text = zodiacSign

        val dateRange = when(zodiacSign) {
            "Aries" -> "Mar 21 - Apr 19"
            "Taurus" -> "Apr 20 - May 20"
            "Gemini" -> "May 21 - Jun 20"
            "Cancer" -> "Jun 21 - Jul 22"
            "Leo" -> "Jul 23 - Aug 22"
            "Virgo" -> "Aug 23 - Sep 22"
            "Libra" -> "Sep 23 - Oct 22"
            "Scorpio" -> "Oct 23 - Nov 21"
            "Sagittarius" -> "Nov 22 - Dec 21"
            "Capricorn" -> "Dec 22 - Jan 19"
            "Aquarius" -> "Jan 20 - Feb 18"
            "Pisces" -> "Feb 19 - Mar 20"
            else -> "Invalid date range"
        }

        when(zodiacSign) {
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

        when(zodiacSign) {
            "Aries" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Taurus" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Gemini" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Cancer" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Leo" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Virgo" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Libra" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Scorpio" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Sagittarius" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Capricorn" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Aquarius" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            "Pisces" -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits_dummy_text)
            else -> binding.tvTraitsDetails.text = getString(R.string.zodiac_sign_traits)
        }

        binding.tvDateRange.text = dateRange

        binding.btnMoreDetails.setOnClickListener {
            val action = ZodiacFragmentDirections
                .actionZodiacFragmentToDetailsFragment(zodiacSign)
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getZodiacSign(birthdate: String): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale("en", "IN"))
        val userBirthDate = dateFormat.parse(birthdate)

        // Extract the year from the user's input date
        val calendar = Calendar.getInstance()
        calendar.time = userBirthDate ?: return "Invalid Date" // Handle parsing errors

        val userBirthYear = calendar.get(Calendar.YEAR)
        val userBirthMonth = calendar.get(Calendar.MONTH) + 1

        // Check for Aries
        var startDate = dateFormat.parse("21/03/$userBirthYear")
        var endDate = dateFormat.parse("19/04/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Aries"
        }

        // Check for Taurus
        startDate = dateFormat.parse("20/04/$userBirthYear")
        endDate = dateFormat.parse("20/05/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Taurus"
        }

        // Check for Gemini
        startDate = dateFormat.parse("21/05/$userBirthYear")
        endDate = dateFormat.parse("20/06/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Gemini"
        }

        // Check for Cancer
        startDate = dateFormat.parse("21/06/$userBirthYear")
        endDate = dateFormat.parse("22/07/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Cancer"
        }

        // Check for Leo
        startDate = dateFormat.parse("23/07/$userBirthYear")
        endDate = dateFormat.parse("22/08/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Leo"
        }

        // Check for Virgo
        startDate = dateFormat.parse("23/08/$userBirthYear")
        endDate = dateFormat.parse("22/09/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Virgo"
        }

        // Check for Libra
        startDate = dateFormat.parse("23/09/$userBirthYear")
        endDate = dateFormat.parse("22/10/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Libra"
        }

        // Check for Scorpio
        startDate = dateFormat.parse("23/10/$userBirthYear")
        endDate = dateFormat.parse("21/11/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Scorpio"
        }

        // Check for Sagittarius
        startDate = dateFormat.parse("22/11/$userBirthYear")
        endDate = dateFormat.parse("21/12/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Sagittarius"
        }

        // Check for Capricorn
        val currentYear = Year.now().value
        if(userBirthYear == currentYear) {
            startDate = dateFormat.parse("22/12/${userBirthYear - 1}")
            endDate = dateFormat.parse("19/01/$userBirthYear")

        } else if(userBirthMonth == 12){
            startDate = dateFormat.parse("22/12/$userBirthYear")
            endDate = dateFormat.parse("19/01/${userBirthYear + 1}")

        } else if (userBirthMonth == 1) {
            startDate = dateFormat.parse("22/12/${userBirthYear - 1}")
            endDate = dateFormat.parse("19/01/$userBirthYear")

        }

        if (userBirthDate in startDate..endDate) {
            return "Capricorn"
        }

        // Check for Aquarius
        startDate = dateFormat.parse("20/01/$userBirthYear")
        endDate = dateFormat.parse("18/02/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Aquarius"
        }

        // Check for Pisces
        startDate = dateFormat.parse("19/02/$userBirthYear")
        endDate = dateFormat.parse("20/03/$userBirthYear")

        if (userBirthDate in startDate..endDate) {
            return "Pisces"
        }

        return "Unknown" // If the date doesn't match any sign
    }

}