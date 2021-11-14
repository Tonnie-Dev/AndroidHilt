package com.example.android.hilt.di

import com.example.android.hilt.navigator.AppNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(impl:AppNavigator):AppNavigator
}