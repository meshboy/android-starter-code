package com.example.mesh.starter_project.core.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 30/12/2018
 */
class NetworkService @Inject constructor(@param:Named("RetrofitMod") val retrofit: Retrofit) {

    val api: API
        get() = retrofit.create(API::class.java)
}