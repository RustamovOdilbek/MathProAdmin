package com.mathpro.admin.ui.fragment.chapter

import com.mathpro.admin.model.chapter.AddChapterResponse
import com.mathpro.admin.model.chapter.ChapterResponse
import com.mathpro.admin.model.chapter.Response
import com.mathpro.admin.model.chapter.EditChapterRequest

interface ChapterViewModel {
    fun allChapters(block: (Result<ChapterResponse>) -> Unit)

    fun addChapter(chapter: String, block: (Result<AddChapterResponse>) -> Unit)

    fun editChapter(id: String, editChapterRequest: EditChapterRequest, block: (Result<Response>) -> Unit)

    fun deleteChapter(id: String, block: (Result<Response>) -> Unit)
}