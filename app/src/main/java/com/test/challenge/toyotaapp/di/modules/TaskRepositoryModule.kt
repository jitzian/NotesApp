package com.test.challenge.toyotaapp.di.modules

import android.app.Application
import com.test.challenge.toyotaapp.data.domain.repository.TaskRepository
import com.test.challenge.toyotaapp.data.domain.repository.TaskRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TaskRepositoryModule {

    @Singleton
    @Provides
    fun providesTaskRepository(context: Application): TaskRepository = TaskRepositoryImpl(context)

}