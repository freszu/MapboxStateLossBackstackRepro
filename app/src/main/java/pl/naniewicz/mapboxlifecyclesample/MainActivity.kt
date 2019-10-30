package pl.naniewicz.mapboxlifecyclesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.maps.SupportMapFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val mapFragment = if (savedInstanceState == null) {
            val mapFragment =
            //SupportMapFragment.newInstance()
                // uncomment for fragment using MapView with no state save logs
                LoggingSupportMapFragment()
            // uncomment for fragmne using MapView with state save kigs
            // LoggingSupportMapFragmentCopy()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, mapFragment, MAP_FRAG_TAG)
            }.commit()
            mapFragment
        } else {
            supportFragmentManager.findFragmentByTag(MAP_FRAG_TAG) as SupportMapFragment
        }
        mapFragment.getMapAsync { it.setStyle(Style.SATELLITE) }

        goToNext.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .addToBackStack("sample")
                .commit()
        }
    }

    companion object {
        private const val MAP_FRAG_TAG = "MAP_FRAG"
    }
}
