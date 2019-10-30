package pl.naniewicz.mapboxlifecyclesample

import android.app.Application
import com.mapbox.mapboxsdk.Mapbox


class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(this, this.getString(R.string.mapbox_token))
    }
}
