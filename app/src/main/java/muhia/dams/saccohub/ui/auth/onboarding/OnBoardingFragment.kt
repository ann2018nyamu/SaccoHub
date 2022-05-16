package muhia.dams.saccohub.ui.auth.onboarding

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import cn.pedant.SweetAlert.SweetAlertDialog
import muhia.dams.saccohub.R
import muhia.dams.saccohub.adapters.OnBoardingAdapter
import muhia.dams.saccohub.databinding.FragmentOnBoardingBinding
import muhia.dams.saccohub.utils.PrefUtils
import muhia.dams.saccohub.utils.autoPlayAdvertisement
import muhia.dams.saccohub.utils.constant.Constants
import timber.log.Timber

class OnBoardingFragment : Fragment() {
   private lateinit var binding:FragmentOnBoardingBinding
    private var pagerPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentOnBoardingBinding.inflate(layoutInflater)
        loadSliders()
        handleBackButton()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSkip.setOnClickListener {
             PrefUtils.setPreference(requireContext(), "isExisting","false")
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
            Timber.d("TV SKIP")
        }

    }
    private fun loadSliders(){
        /*val onBoardingAdapter = OnBoardingAdapter()
        binding.pager.setAdapter(onBoardingAdapter)
        binding.pager.setOffscreenPageLimit(4) //For smooth transitions*/


        val onBoardingAdapter = OnBoardingAdapter(requireContext())
        binding.pager.adapter =onBoardingAdapter
        binding.tabDots.setupWithViewPager(binding.pager, true)
        onBoardingAdapter.notifyDataSetChanged()

        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
//             binding.adsViewPager.currentItem=
                if (position==0){
                    binding.tvSliderDescr.setText(R.string.you_can_now_start)
                }else if (position==1){
                    binding.tvSliderDescr.setText(R.string.you_can_now_send)
                }else{
                    binding.tvSliderDescr.setText(R.string.you_can_now_get_instant)

                }
            }

            override fun onPageSelected(position: Int) {



            }
        })
        autoPlayAdvertisement(binding.pager)

    }
    //phone back button
    private fun handleBackButton() {
        // This callback will only be called when this Fragment is at least Started.
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    // dialog asking to exit the app or not, (yes to finish the activity)
                    SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)

                        .setTitleText("Confirm Exit")
                        .setContentText("Are you sure you want to exit?")
                        .setConfirmText("Yes")
                        .setConfirmButtonBackgroundColor(Color.RED)
                        .setConfirmClickListener { sDialog ->
                            activity!!.finish()
                            sDialog.dismissWithAnimation()
                        }
                        .setCancelButtonBackgroundColor(Color.BLUE)
                        .setCancelButton(
                            "No"
                        )
                        { sDialog ->
                            sDialog.dismissWithAnimation()
                        }
                        .show()
                    // findNavController().navigateUp()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }

}