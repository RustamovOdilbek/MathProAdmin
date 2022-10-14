package com.mathpro.admin.ui.fragment.registration

import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.login.LoginResponse

interface RegistrationViewModel {
    fun login(loginRequest: LoginRequest, block: (Result<LoginResponse>) -> Unit)
}