package com.syakir.academy.data.source

import com.syakir.academy.data.CourseEntity
import com.syakir.academy.data.ModuleEntity

interface AcademyDataSource {

    fun getAllCourses(): List<CourseEntity>

    fun getBookmarkedCourse(): List<CourseEntity>

    fun getCourseWithModules(courseId: String): CourseEntity

    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>

    fun getContent(courseId: String, moduleId: String): ModuleEntity
}