package muhia.dams.saccohub.ui.auth.login

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import muhia.dams.saccohub.MainActivity
import muhia.dams.saccohub.R
import muhia.dams.saccohub.databinding.LoginFragmentBinding
import muhia.dams.saccohub.utils.PrefUtils
import muhia.dams.saccohub.utils.constant.Constants

class LoginFragment : Fragment() {
    lateinit var binding: LoginFragmentBinding

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (PrefUtils.getPreferences(context!!, "isExisting")!=("false"))
         {
            findNavController().navigate(R.id.action_loginFragment_to_onBoardingFragment)
        }
        binding= LoginFragmentBinding.inflate(layoutInflater)

        binding.btnCreateAc.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_personalDetailsFragment)
        }
        return binding.root
    }





}