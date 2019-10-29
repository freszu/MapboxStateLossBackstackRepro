package pl.naniewicz.mapboxlifecyclesample

import android.content.Context
import android.os.Parcelable
import android.util.Log
import com.mapbox.mapboxsdk.maps.MapView

/**
 * Extends [MapView] and ads logs of state saving methods
 */
class MapViewWithState(context: Context) : MapView(context) {

    override fun onSaveInstanceState(): Parcelable? {
        Log.d(TAG, "on save state called")
        return super.onSaveInstanceState()
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        Log.d(TAG, "on restore state called")
        super.onRestoreInstanceState(state)
    }

    companion object {
        private const val TAG = "MapViewWithState"
    }

}
