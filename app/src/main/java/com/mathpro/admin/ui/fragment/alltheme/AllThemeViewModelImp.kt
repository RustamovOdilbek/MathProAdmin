package com.mathpro.admin.ui.fragment.alltheme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathpro.admin.model.alltheme.ThemesResponse
import com.mathpro.admin.repository.AuthRepository
import com.mathpro.admin.ui.fragment.chapter.ChapterViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllThemeViewModelImp @Inject constructor(private val authRepository: AuthRepository):
    ViewModel(),
    AllThemeViewModel
{
    override fun createLesson(id: String, block: (Result<ThemesResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.allThemes(id)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

}