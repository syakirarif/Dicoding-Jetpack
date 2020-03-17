package com.syakir.academy.bookmark

import com.syakir.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
