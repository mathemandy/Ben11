package ng.mathemandy.venten

import androidx.multidex.MultiDexApplication
import ng.mathemandy.venten.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp  : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApp)
            modules(appModule)
        }
    }
}