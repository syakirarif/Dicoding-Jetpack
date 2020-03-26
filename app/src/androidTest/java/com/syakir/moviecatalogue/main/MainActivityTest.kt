package com.syakir.moviecatalogue.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.syakir.moviecatalogue.R
import com.syakir.moviecatalogue.utils.DataDummy
import com.syakir.moviecatalogue.utils.DateConverter
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvshows = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    // test untuk menampilkan list movie
    @Test
    fun loadMovies() {

        //cek keberadaan tabs
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))

        //klik menu toolbar "MOVIES"
        onView(withText("MOVIES")).perform(click())

        // cek keberadaan rv_movies
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

        // lakukan scroll untuk rv_movies
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    // test untuk mengampilkan detail movie yang dipilih
    @Test
    fun loadDetailMovie() {

        //cek keberadaan tabs
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))

        //klik menu toolbar "MOVIES"
        onView(withText("MOVIES")).perform(click())

        //cek keberadaan rv_movies
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))

        // klik salah satu poster movie
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        // cek keberadaan img_detail_backdrop
        onView(withId(R.id.img_detail_backdrop)).check(matches(isDisplayed()))

        // cek keberadaan img_detail_poster
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))

        // cek keberadaan tv_title lalu cek kecocokan datanya
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovies[0].title)))

        // cek keberadaan tv_avg_rating lalu cek kecocokan datanya
        onView(withId(R.id.tv_avg_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_avg_rating)).check(matches(withText("Rating: ${dummyMovies[0].vote_avg}")))

        //cek keberadaan tv_overview lalu cek kecocokan datanya
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovies[0].overview)))

        //cek kecocokan data tv_release_date
        onView(withId(R.id.tv_release_date)).check(matches(withText(DateConverter.getLongDate(dummyMovies[0].release_date))))
    }


    // test untuk menampilkan list tv show
    @Test
    fun loadTvShows() {

        //cek keberadaan tabs
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))

        //klik menu toolbar "TV SHOW"
        onView(withText("TV SHOW")).perform(click())

        // cek keberadaan rv_tv
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))

        // lakukan scroll untuk rv_tv
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvshows.size
            )
        )
    }

    // test untuk menampilkan detail tv show yang dipilih
    @Test
    fun loadDetailTvShow() {

        //cek keberadaan tabs
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))

        //klik menu toolbar "TV SHOW"
        onView(withText("TV SHOW")).perform(click())

        //cek keberadaan rv_tv
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))

        // klik salah satu poster tv show
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        // cek keberadaan img_detail_backdrop
        onView(withId(R.id.img_detail_backdrop)).check(matches(isDisplayed()))

        // cek keberadaan img_detail_poster
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))

        // cek keberadaan tv_title lalu cek kecocokan datanya
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvshows[0].title)))

        // cek keberadaan tv_avg_rating lalu cek kecocokan datanya
        onView(withId(R.id.tv_avg_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_avg_rating)).check(matches(withText("Rating: ${dummyTvshows[0].vote_avg}")))

        //cek keberadaan tv_overview lalu cek kecocokan datanya
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvshows[0].overview)))

        //cek keberadaan tv_release_date lalu cek kecocokan datanya
        onView(withId(R.id.tv_release_date)).check(matches(withText(DateConverter.getLongDate(dummyTvshows[0].first_air_date))))
    }



}