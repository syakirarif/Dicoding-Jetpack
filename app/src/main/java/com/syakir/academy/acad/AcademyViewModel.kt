package com.syakir.academy.acad

import androidx.lifecycle.ViewModel
import com.syakir.academy.data.CourseEntity
import com.syakir.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()
}