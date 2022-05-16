package muhia.dams.saccohub.ui.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import muhia.dams.saccohub.R
import muhia.dams.saccohub.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    lateinit var binding:FragmentDashboardBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding= FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

}