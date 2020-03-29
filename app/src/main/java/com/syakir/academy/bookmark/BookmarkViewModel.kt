package com.syakir.academy.bookmark

import androidx.lifecycle.ViewModel
import com.syakir.academy.data.CourseEntity
import com.syakir.academy.data.source.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourse()
}