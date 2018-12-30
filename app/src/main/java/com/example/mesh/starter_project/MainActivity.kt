package com.example.mesh.starter_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mesh.starter_project.core.di.components.DaggerApplicationComponent
import com.example.mesh.starter_project.core.di.modules.ContextModule
import com.example.mesh.starter_project.core.di.modules.NetworkModule
import com.example.mesh.starter_project.core.network.NetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var networkService: NetworkService

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


//        a demonstration of dagger usage in starter project
        DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this))
            .networkModule(NetworkModule())
            .build().inject(this)
    }

}
