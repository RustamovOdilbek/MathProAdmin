package com.mathpro.admin.repository

import com.mathpro.admin.model.chapter.EditChapterRequest
import com.mathpro.admin.model.lesson.CreateLessonRequest
import com.mathpro.admin.model.login.LoginRequest
import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.module.service.ApiService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)

    suspend fun allUsers() = apiService.allUsers()

    suspend fun deleteUser(usersDeleteRequest: UserDeleteRequest) =
        apiService.deleteUser(usersDeleteRequest)

    suspend fun allChapters() = apiService.allChapters()

    suspend fun addChapter(chapter: String) = apiService.addChapter(chapter)

    suspend fun editChapter(id: String, editChapterResponse: EditChapterRequest) =
        apiService.editChapter(id, editChapterResponse)

    suspend fun deleteChapter(id: String) = apiService.deleteChapter(id)

    suspend fun createLesson(createLessonRequest: CreateLessonRequest) = apiService.createLesson(createLessonRequest)
}