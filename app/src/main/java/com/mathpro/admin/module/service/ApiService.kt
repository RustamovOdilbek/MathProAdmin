package com.mathpro.admin.module.service

import com.mathpro.admin.model.chapter.AddChapterResponse
import com.mathpro.admin.model.chapter.ChapterResponse
import com.mathpro.admin.model.chapter.EditChapterRequest
import com.mathpro.admin.model.chapter.Response
import com.mathpro.admin.model.lesson.CreateLessonRequest
import com.mathpro.admin.model.lesson.CreateLessonResponse
import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.login.LoginResponse
import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.model.user.UserDeleteResponse
import com.mathpro.admin.model.user.UsersResponse
import retrofit2.http.*

interface ApiService {

    @POST("admin/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("admin/users/all")
    suspend fun allUsers(): UsersResponse

    @HTTP(method = "DELETE", path = "admin/users/delete", hasBody = true)
    suspend fun deleteUser(@Body userDeleteRequest: UserDeleteRequest): UserDeleteResponse

    @GET("get/all/bob/")
    suspend fun allChapters(): ChapterResponse

    @POST("admin/lessons/create/bob")
    @FormUrlEncoded
    suspend fun addChapter(@Field("name") chapter: String): AddChapterResponse

    @PUT("admin/lessons/update/bob/")
    suspend fun editChapter(@Path ("ID") id: String, @Body editRequest: EditChapterRequest):
            Response

    @DELETE("admin/lessons/delete/bob")
    suspend fun deleteChapter(@Path ("ID") id: String): Response

    @POST("admin/lessons/create/lesson")
    suspend fun createLesson(@Body createLessonRequest: CreateLessonRequest): CreateLessonResponse

}