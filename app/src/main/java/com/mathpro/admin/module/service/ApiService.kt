package com.mathpro.admin.module.service

import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.login.LoginResponse
import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.model.user.UserDeleteResponse
import com.mathpro.admin.model.user.UsersResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("admin/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("admin/users/all")
    suspend fun allUsers(): ArrayList<UsersResponse>

    @DELETE("admin/users/delete")
    suspend fun deleteUser(@Body userDeleteRequest: UserDeleteRequest): UserDeleteResponse

}