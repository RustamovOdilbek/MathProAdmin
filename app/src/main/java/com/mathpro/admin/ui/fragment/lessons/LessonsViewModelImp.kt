package com.mathpro.admin.ui.fragment.lessons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathpro.admin.model.chapter.ChapterResponse
import com.mathpro.admin.model.lesson.CreateLessonRequest
import com.mathpro.admin.model.lesson.CreateLessonResponse
import com.mathpro.admin.repository.AuthRepository
import com.mathpro.admin.ui.fragment.users.UserViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonsViewModelImp @Inject constructor(private val authRepository: AuthRepository):
    ViewModel(),
    LessonsViewModel {
    override fun createLesson(
        createLessonRequest: CreateLessonRequest,
        block: (Result<CreateLessonResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.createLesson(createLessonRequest)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun allChapters(block: (Result<ChapterResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.allChapters()))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }
}