package com.syakir.academy.detail

import androidx.lifecycle.ViewModel
import com.syakir.academy.data.CourseEntity
import com.syakir.academy.data.ModuleEntity
import com.syakir.academy.data.source.AcademyRepository

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

}