package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.LogApplication
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module


@InstallIn(SingletonComponent::class)


/*tells Hilt the containers where the bindings are available
by specifying a Hilt component*/


object DatabaseModule {

    @Provides // tell hilt how to provide types that cannot be
    //constructor-injected

//the fxn parameter are dependencies of type to be provided
    fun provideDAO(database: AppDatabase): LogDao {


        return database.logDao()
    }


    /*Since we have AppDatabase as a transitive dependency, we
    also need to tell Hilt how to provide instances of that type.*/

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "logging.dp"
        ).build()
    }

}