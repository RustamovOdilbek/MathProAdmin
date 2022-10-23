package com.mathpro.admin.module.service

import com.mathpro.admin.model.Response
import com.mathpro.admin.model.alltheme.ThemesResponse
import com.mathpro.admin.model.chapter.*
import com.mathpro.admin.model.lesson.CreateLessonRequest
import com.mathpro.admin.model.lesson.CreateLessonResponse
import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.login.LoginResponse
import com.mathpro.admin.model.theme.*
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
    suspend fun addChapter(@Body chapter: AddRequest): AddChapterResponse

    @PUT("admin/lessons/update/bob/")
    suspend fun editChapter(@Path ("ID") id: String, @Body editRequest: EditChapterRequest):
            Response

    @DELETE("admin/lessons/delete/bob")
    suspend fun deleteChapter(@Path ("ID") id: String): Response

    @POST("admin/lessons/create/lesson")
    suspend fun createLesson(@Body createLessonRequest: CreateLessonRequest): CreateLessonResponse

    @DELETE("admin/lessons/delete/lesson")
    suspend fun deleteLesson(deleteLessonRequest: DeleteLessonRequest): Response

    //bobId allThemes

    @GET("get/all/lesson/{ID}")
    suspend fun allThemes(@Path ("ID") id: String) : ThemesResponse

    //edit theme
    @GET()

    @PUT("admin/lessons/update/description")
    suspend fun editDescription(@Body descriptionRequest: DescriptionRequest): Response

    @PUT("admin/lessons/update/pdf")
    suspend fun editPdfLink(@Body pdfRequest: PdfRequest): Response

    @PUT("admin/lessons/update/theme")
    suspend fun editTheme(@Body themeRequest: ThemeRequest): Response

    @PUT("admin/lessons/update/video")
    suspend fun editVedio(@Body vedioRequest: VedioRequest): Response

}