package com.syakir.academy.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syakir.academy.acad.AcademyViewModel
import com.syakir.academy.bookmark.BookmarkViewModel
import com.syakir.academy.data.source.AcademyRepository
import com.syakir.academy.detail.DetailCourseViewModel
import com.syakir.academy.di.Injection
import com.syakir.academy.reader.CourseReaderViewModel

class ViewModelFactory private constructor(private val academyRepository: AcademyRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        private var instace : ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instace ?: synchronized(this) {
                instace ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
                return AcademyViewModel(academyRepository) as T
            }
            modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
                return DetailCourseViewModel(academyRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                return BookmarkViewModel(academyRepository) as T
            }
            modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
                return CourseReaderViewModel(academyRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}