package dev.brookmg.aadproject

import android.app.Application
import dev.brookmg.aadproject.network.API

class App : Application() {

    companion object {
        val api: API by lazy { API() }
    }

}