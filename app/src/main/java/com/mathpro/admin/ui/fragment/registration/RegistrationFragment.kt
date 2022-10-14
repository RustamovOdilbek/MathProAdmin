package com.mathpro.admin.ui.fragment.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mathpro.admin.R
import com.mathpro.admin.databinding.FragmentRegistrationBinding
import com.mathpro.admin.helper.SharedPref
import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.utils.KeyValues.USER_TOKEN
import com.mathpro.admin.utils.viewExtension.snackBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    @Inject
    lateinit var sharedPref: SharedPref
    private val TAG = "RegistrationFragment"
    private val binding by viewBinding(FragmentRegistrationBinding::bind)
    private val viewModel: RegistrationViewModel by viewModels<RegistrationViewModelImp>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        binding.btnLogin.setOnClickListener {

            if (isFieldsFilled()){
                viewModel.login(getLogin()){
                    it.onSuccess { loginResponse ->
                        snackBar(loginResponse.Message.toString())
                        Log.d(TAG, "initViews: ${loginResponse}")
                        sharedPref.saveUserToken(USER_TOKEN, loginResponse.Token!!)
                        Log.d(TAG, "initViews: ${sharedPref.getUserToken(USER_TOKEN, "")}")
                        findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
                    }
                    it.onFailure {
                        snackBar(getString(R.string.str_incorrent_login))
                    }
                }
            }else{
                snackBar(getString(R.string.str_fields_not_filled))
            }

        }
    }
    private fun isFieldsFilled() = binding.etLogin.text!!.isNotEmpty() && binding.etParol.text!!.isNotEmpty()

    private fun getLogin() = LoginRequest(
        binding.etLogin.text.toString(),
        binding.etParol.text.toString()
    )

}