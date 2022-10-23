package com.mathpro.admin.ui.fragment.theme

import com.mathpro.admin.model.Response
import com.mathpro.admin.model.theme.DescriptionRequest
import com.mathpro.admin.model.theme.PdfRequest
import com.mathpro.admin.model.theme.ThemeRequest
import com.mathpro.admin.model.theme.VedioRequest

interface ThemeViewModel {


    fun editDescription(descriptionRequest: DescriptionRequest, block: (Result<Response>) -> Unit)

    fun editPdf(pdfRequest: PdfRequest, block: (Result<Response>) -> Unit)

    fun editVedio(vedioRequest: VedioRequest, block: (Result<Response>) -> Unit)

    fun editTheme(themeRequest: ThemeRequest, block: (Result<Response>) -> Unit)


}