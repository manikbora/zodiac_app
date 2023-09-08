package com.example.myzodiacapp.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myzodiacapp.databinding.FragmentMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.etDOB.setOnClickListener {
            showDatePickerDialog()
        }


        binding.btnShowZodiacSign.setOnClickListener {
            val userName = binding.etName.text.toString().trim()
            val dob = binding.etDOB.text.toString().trim()
            if(userName.isNotEmpty() && dob.isNotEmpty()) {
                val action = MainFragmentDirections
                    .actionMainFragmentToZodiacFragment(userName,dob)
                view.findNavController().navigate(action)
            }
        }
        return view
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Handle date selection
                calendar.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
                binding.etDOB.setText(dateFormat.format(calendar.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis() - 1000
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}