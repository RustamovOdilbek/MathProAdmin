package com.mathpro.admin.ui.fragment.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.login.LoginResponse
import com.mathpro.admin.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModelImp @Inject constructor(private val authRepository: AuthRepository):
    ViewModel(),
    RegistrationViewModel{

    override fun login(loginRequest: LoginRequest, block: (Result<LoginResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.login(loginRequest)))
            }catch (e:Exception){
                block(Result.failure(e))
            }
        }
    }

}