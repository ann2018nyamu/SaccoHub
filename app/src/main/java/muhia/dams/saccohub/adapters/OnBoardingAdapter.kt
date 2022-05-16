package muhia.dams.saccohub.adapters

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import muhia.dams.saccohub.R

class OnBoardingAdapter(var context: Context):PagerAdapter() {
    private val layoutInflater: LayoutInflater

    private val splashscreenTitle = arrayOfNulls<String>(3)
    private val splashscreenDescriptions = arrayOfNulls<String>(3)
    private val splaschreenimages = intArrayOf(
        R.drawable.slider_one_iv, R.drawable.slider_two_iv,
        R.drawable.slider_three_iv
    )
    init {
        layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    // // Returns the number of pages/items to be displayed in the ViewPager.
    override fun getCount(): Int {
      return splashscreenTitle.size

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.intro_slider_row, container, false)
        splashscreenTitle[0] = context.getString(R.string.save_grow)
        splashscreenTitle[1] = context.getString(R.string.quick_money)
        splashscreenTitle[2] = context.getString(R.string.get_instant_loan)

        splashscreenDescriptions[0] = context.getString(R.string.you_can_now_start)
        splashscreenDescriptions[1] = context.getString(R.string.you_can_now_send)
        splashscreenDescriptions[2] = context.getString(R.string.you_can_now_get_instant)

        val tvSplashScreenTitle: TextView
        val tvSplashScreenDescri: TextView
        val imgSplashScreen: ImageView

        tvSplashScreenTitle = view.findViewById(R.id.tv_slider_title)
        imgSplashScreen = view.findViewById(R.id.iv_slider)
//        tvSplashScreenDescri=view.findViewById(R.id.tv_slider_descr)

        tvSplashScreenTitle.text = splashscreenTitle[position]
     //   tvSplashScreenDescri.text=splashscreenDescriptions[position]

       imgSplashScreen.setImageResource(splaschreenimages[position])

        container.addView(view)

        return view

    }
    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as LinearLayout)
    }

}