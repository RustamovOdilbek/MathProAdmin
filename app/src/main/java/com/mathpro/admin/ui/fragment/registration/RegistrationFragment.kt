package com.mathpro.admin.ui.fragment.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentRegistrationBinding
import com.mathpro.admin.helper.SharedPref
import com.mathpro.admin.utils.KeyValues.LOG_IN

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var sharedPref: SharedPref

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistrationBinding.bind(view)
        sharedPref = SharedPref(requireContext())

        initViews()
    }

    private fun initViews() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
            sharedPref.saveLogIn(LOG_IN, true)
        }
    }

}