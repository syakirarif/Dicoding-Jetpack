package com.syakir.academy.bookmark

import com.syakir.academy.data.CourseEntity
import com.syakir.academy.data.source.AcademyRepository
import com.syakir.academy.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    lateinit var viewModel: BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmarks() {
        Mockito.`when`<List<CourseEntity>>(academyRepository.getBookmarkedCourse()).thenReturn(DataDummy.generateDummyCourses())
        val bookmarks = viewModel.getBookmarks()
        Mockito.verify<AcademyRepository>(academyRepository).getBookmarkedCourse()
        assertNotNull(bookmarks)
        assertEquals(5, bookmarks.size)
    }
}