package pl.naniewicz.mapboxlifecyclesample

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.core.os.bundleOf
import com.mapbox.mapboxsdk.maps.MapView

/**
 * Extends [MapView] and ads logs of state saving methods
 */
class MapViewWithState(context: Context) : MapView(context) {

    override fun onSaveInstanceState(): Parcelable? {
        Log.d(TAG, "on save state called")
        return bundleOf("state" to "state", "super" to super.onSaveInstanceState())
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        Log.d(TAG, "on restore state called $state")
        super.onRestoreInstanceState((state as Bundle).getParcelable("super"))
    }

    companion object {
        private const val TAG = "MapViewWithState"
    }

}
