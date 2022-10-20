package com.mathpro.admin.ui.fragment.chapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathpro.admin.model.chapter.AddChapterResponse
import com.mathpro.admin.model.chapter.ChapterResponse
import com.mathpro.admin.model.chapter.EditChapterRequest
import com.mathpro.admin.model.chapter.Response
import com.mathpro.admin.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChapterViewModelImp @Inject constructor(private val authRepository: AuthRepository):
    ViewModel(),
    ChapterViewModel
{
    override fun allChapters(block: (Result<ChapterResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.allChapters()))
            }catch (e:Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun addChapter(chapter: String, block: (Result<AddChapterResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.addChapter(chapter)))
            }catch (e:Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun editChapter(
        id: String,
        editChapterRequest: EditChapterRequest,
        block: (Result<Response>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.editChapter(id = id, editChapterResponse = editChapterRequest)))
            }catch (e:Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun deleteChapter(id: String, block: (Result<Response>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.deleteChapter(id)))
            }catch (e:Exception){
                block(Result.failure(e))
            }
        }
    }
}