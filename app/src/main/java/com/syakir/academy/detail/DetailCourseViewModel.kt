package com.syakir.academy.detail

import androidx.lifecycle.ViewModel
import com.syakir.academy.data.CourseEntity
import com.syakir.academy.data.ModuleEntity
import com.syakir.academy.utils.DataDummy

class DetailCourseViewModel : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity

        val coursesEntities = DataDummy.generateDummyCourses()

        for (courseEntity in coursesEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }

        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)

}