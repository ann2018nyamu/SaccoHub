package muhia.dams.saccohub.ui.auth.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_splash.*
import muhia.dams.saccohub.MainActivity
import muhia.dams.saccohub.R
import muhia.dams.saccohub.databinding.ActivitySplashBinding
import muhia.dams.saccohub.utils.PrefUtils
import muhia.dams.saccohub.utils.constant.Constants

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_splash)
        /*Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)*/

        anim_intro.alpha = 0f
        anim_intro.animate().setDuration(2000).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}