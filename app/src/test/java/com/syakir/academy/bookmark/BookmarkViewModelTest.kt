package com.syakir.academy.bookmark

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class BookmarkViewModelTest {

    lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmarks() {
        val bookmarks = viewModel.getBookmarks()
        assertNotNull(bookmarks)
        assertEquals(5, bookmarks.size)
    }
}