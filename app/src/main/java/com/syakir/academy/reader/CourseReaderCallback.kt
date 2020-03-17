package com.syakir.academy.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}