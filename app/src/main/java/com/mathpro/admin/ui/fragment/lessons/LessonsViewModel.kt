package com.mathpro.admin.ui.fragment.lessons

import com.mathpro.admin.model.chapter.ChapterResponse
import com.mathpro.admin.model.lesson.CreateLessonRequest
import com.mathpro.admin.model.lesson.CreateLessonResponse

interface LessonsViewModel {

    fun createLesson(createLessonRequest: CreateLessonRequest,
                     block: (Result<CreateLessonResponse>) -> Unit)

    fun allChapters(block: (Result<ChapterResponse>) -> Unit)
}