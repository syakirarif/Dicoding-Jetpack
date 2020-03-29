package com.syakir.academy.di

import android.content.Context
import com.syakir.academy.data.source.AcademyRepository
import com.syakir.academy.data.source.remote.RemoteDataSource
import com.syakir.academy.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}