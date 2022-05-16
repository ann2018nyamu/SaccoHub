package muhia.dams.saccohub.utils

import android.content.Context
import android.os.Handler
import android.preference.PreferenceManager
import androidx.viewpager.widget.ViewPager
import java.util.*

object PrefUtils {
    private const val PREFS_NAME = "Sacco Hub"


    /*****set/store shared preferences  */
    fun setPreference(con: Context, key: String?, value: String?) {
        val preferences = con.getSharedPreferences(PREFS_NAME, 0)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }



    /*** get/retrieve shared preferences   */
    fun getPreferences(con: Context, key: String?): String? {
        val sharedPreferences = con.getSharedPreferences(PREFS_NAME, 0)
        return sharedPreferences.getString(key, "0")
    }

    fun clear(con: Context) {
        val sharedPrefs = con.getSharedPreferences(PREFS_NAME, 0)
        val editor = sharedPrefs.edit()
        editor.clear()
        editor.apply()
    }

}
private var pagerPosition = 0
fun autoPlayAdvertisement(viewPager: ViewPager) {
    Handler().postDelayed(Runnable {
        if (pagerPosition == Objects.requireNonNull(viewPager.adapter)!!.count - 1
        ) {
            pagerPosition = 0
            viewPager.currentItem = pagerPosition
        } else {
            viewPager.currentItem = 1.let {
                pagerPosition += it;
                pagerPosition
            }
        }
        autoPlayAdvertisement(viewPager)
    }, 4000)
}
