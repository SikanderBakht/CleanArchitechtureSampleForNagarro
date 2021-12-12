package com.sikander.nagarrocleanarchassignment.application

import android.os.StrictMode
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class NagarroCleanArchAssignmentApp : MultiDexApplication() {
    /*@Inject
    lateinit var dataStoreManager: DataStoreManager*/

    override fun onCreate() {
        if (true) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork() // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    //.penaltyDeath() //TODO
                    .build()
            )
        }
        super.onCreate()
        //Timber.plant(Timber.DebugTree())
    }
}