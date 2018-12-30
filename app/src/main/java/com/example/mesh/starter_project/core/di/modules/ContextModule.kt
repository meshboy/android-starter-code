package com.example.mesh.starter_project.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/12/2018
 */
@Module
class ContextModule(private  var context: Context) {

    @Provides
    fun providesContext(): Context {
        return context
    }
}