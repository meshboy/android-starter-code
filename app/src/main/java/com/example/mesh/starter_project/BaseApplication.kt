package com.example.mesh.starter_project

import android.app.Application
import com.example.mesh.starter_project.core.di.components.DaggerApplicationComponent
import com.example.mesh.starter_project.core.di.modules.ContextModule
import com.example.mesh.starter_project.core.di.modules.NetworkModule
import timber.log.Timber

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/12/2018
 */

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}