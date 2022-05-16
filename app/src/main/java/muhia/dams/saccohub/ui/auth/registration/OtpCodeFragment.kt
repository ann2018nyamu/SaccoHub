package muhia.dams.saccohub.ui.auth.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_otp_code.*
import muhia.dams.saccohub.R
import muhia.dams.saccohub.databinding.FragmentOnBoardingBinding
import muhia.dams.saccohub.databinding.FragmentOtpCodeBinding


class OtpCodeFragment : Fragment() {
lateinit var binding:FragmentOtpCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentOtpCodeBinding.inflate(layoutInflater)
        binding.btnOtpContinue.setOnClickListener {
            findNavController().navigate(R.id.action_otpCodeFragment_to_dashboardFragment)
        }
        return binding.root
    }


}