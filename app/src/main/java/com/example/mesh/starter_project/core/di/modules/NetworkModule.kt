package com.example.mesh.starter_project.core.di.modules

import android.content.Context
import com.example.mesh.starter_project.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/12/2018
 */
@Module(includes = [ContextModule::class])
class NetworkModule {

    @Provides
    fun providesLogggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
    }

    @Provides
    fun providesFile(providesContext: Context): File {
        return File(providesContext.cacheDir, "okhttp-network-cache")
    }

    @Provides
    fun providesCacheFile(providesFile: File): Cache {
        return Cache(providesFile, 10 * 1000 * 1000) //10MB cache
    }

    @Provides
    fun providesOkHttpClient(providesLoggingInterceptor: HttpLoggingInterceptor, providesCache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(providesLoggingInterceptor)
            .cache(providesCache)
            .build()
    }

    @Provides
    fun providesGson(): Gson {
       return GsonBuilder().setLenient().create()
    }

    @Provides
    @Named("RetrofitMod")
    fun retrofit(providesGson: Gson, providesOkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(providesGson))
            .client(providesOkHttpClient)
            .baseUrl(BuildConfig.APP_BASE_URL)
            .build()
    }
}