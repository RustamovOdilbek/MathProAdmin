package com.mathpro.admin.repository

import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.module.service.ApiService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)

    suspend fun allUsers() = apiService.allUsers()

    suspend fun deleteUser(userDeleteRequest: UserDeleteRequest) = apiService.deleteUser(userDeleteRequest)
}