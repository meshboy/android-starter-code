package com.example.mesh.starter_project.core.di.components

import com.example.mesh.starter_project.MainActivity
import com.example.mesh.starter_project.core.di.modules.ContextModule
import com.example.mesh.starter_project.core.di.modules.NetworkModule
import dagger.Component

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/12/2018
 */
@Component(modules = [NetworkModule::class, ContextModule::class])
interface ApplicationComponent {

    fun inject (mainActivity: MainActivity)
}