package com.mathpro.admin.ui.fragment.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathpro.admin.model.Response
import com.mathpro.admin.model.theme.DescriptionRequest
import com.mathpro.admin.model.theme.PdfRequest
import com.mathpro.admin.model.theme.ThemeRequest
import com.mathpro.admin.model.theme.VedioRequest
import com.mathpro.admin.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModelImpl @Inject constructor(private val authRepository: AuthRepository):
    ViewModel(),
    ThemeViewModel
{
    override fun editDescription(
        descriptionRequest: DescriptionRequest,
        block: (Result<Response>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.editDescription(descriptionRequest)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun editPdf(pdfRequest: PdfRequest, block: (Result<Response>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.editPdfLink(pdfRequest)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun editVedio(vedioRequest: VedioRequest, block: (Result<Response>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.editVedio(vedioRequest)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun editTheme(themeRequest: ThemeRequest, block: (Result<Response>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.editTheme(themeRequest)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }

}