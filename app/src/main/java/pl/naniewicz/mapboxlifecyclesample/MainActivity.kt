package pl.naniewicz.mapboxlifecyclesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.Style
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this, this.getString(R.string.mapbox_token))
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    // uncomment for fragment using MapView with no state save logs
                    LoggingSupportMapFragment()
                        // uncomment for fragmne using MapView with state save kigs
                        // LoggingSupportMapFragmentCopy()
                        .apply {
                            getMapAsync {
                                it.setStyle(Style.Builder().fromUri("mapbox://styles/mapbox/cjf4m44iw0uza2spb3q0a7s41"))
                            }
                        })
                .commitNow()
        }

        goToNext.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .addToBackStack("mainfrag")
                .commit()
        }
    }

}


