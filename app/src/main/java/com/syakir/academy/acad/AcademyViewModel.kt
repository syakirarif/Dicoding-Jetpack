package com.syakir.academy.acad

import androidx.lifecycle.ViewModel
import com.syakir.academy.data.CourseEntity
import com.syakir.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}