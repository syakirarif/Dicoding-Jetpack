package com.syakir.academy.bookmark

import androidx.lifecycle.ViewModel
import com.syakir.academy.data.CourseEntity
import com.syakir.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}