@file:Suppress("DEPRECATION")

package muhia.dams.saccohub.ui.auth.registration

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import muhia.dams.saccohub.R
import muhia.dams.saccohub.databinding.FragmentPersonalDetailsBinding
import java.text.SimpleDateFormat
import java.util.*
@SuppressLint("UseCompatLoadingForDrawables")
class PersonalDetailsFragment : Fragment() {
    lateinit var binding:FragmentPersonalDetailsBinding
    var currentLayout=1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPersonalDetailsBinding.inflate(layoutInflater)
        binding.etDob.setOnClickListener {
            pickDob()
        }

        showLayoutOne()
        binding.apply {
            tvRegisterOne.setOnClickListener {
                showLayoutOne()
            }
            tvRegisterTwo.setOnClickListener {
                showLayoutTwo()
            }
            tvRegisterThree.setOnClickListener {
                showLayoutThree()
            }
            tvRegisterFour.setOnClickListener{
                showLayoutFour()
            }
            btnLoginContinue.setOnClickListener {
                when (currentLayout) {
                    1 -> {
                        showLayoutTwo()
                    }
                    2 -> {
                        showLayoutThree()
                    }
                    3 -> {
                        showLayoutFour()
                    }
                    else -> {
                        findNavController().navigate(R.id.action_personalDetailsFragment_to_otpCodeFragment)
                    }
                }
            }
        }


        return  binding.root
        }
    fun pickDob() {
        val dateListener: DatePickerDialog.OnDateSetListener
        val myCalendar = Calendar.getInstance()
        val currYear = myCalendar[Calendar.YEAR]
        val currMonth = myCalendar[Calendar.MONTH]
        val currDay = myCalendar[Calendar.DAY_OF_MONTH]
        dateListener =
            DatePickerDialog.OnDateSetListener { view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                myCalendar[Calendar.YEAR] = year
                myCalendar[Calendar.MONTH] = monthOfYear
                myCalendar[Calendar.DAY_OF_MONTH] = dayOfMonth
                var isDateOk = true
                if (currYear - year < 18) isDateOk = false else if (currYear == 18) {
                    if (currMonth - monthOfYear < 0) isDateOk = false
                    if (currMonth == monthOfYear && currDay - dayOfMonth < 0) isDateOk = false
                }
                if (isDateOk) {
                    val preferredFormat = "dd-MM-yyyy"
                    val date =
                        SimpleDateFormat(preferredFormat, Locale.US).format(myCalendar.time)
                    binding.etDob.setText(date)
                } else {
                    binding.tlDob.error = "Age should be more than 18 years"
                }
            }
        DatePickerDialog(
            requireContext(), dateListener, myCalendar[Calendar.YEAR],
            myCalendar[Calendar.MONTH],
            myCalendar[Calendar.DAY_OF_MONTH]
        ).show()
    }


    fun showLayoutOne(){
        currentLayout=1
        binding.tvRegisterOne.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterTwo.background = resources.getDrawable(R.drawable.unselected_background)
        binding.v1.setBackgroundColor(resources.getColor(R.color.etColor))
        binding.v2.setBackgroundColor(resources.getColor(R.color.etColor))
        binding.v3.setBackgroundColor(resources.getColor(R.color.etColor))

        binding.llOne.visibility=View.VISIBLE
        binding.llTwo.visibility=View.GONE
        binding.llThree.visibility=View.GONE
        binding.llFour.visibility=View.GONE
    }
    fun showLayoutTwo(){
        currentLayout=2
        binding.tvRegisterOne.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterTwo.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterThree.background = resources.getDrawable(R.drawable.unselected_background)
        binding.tvRegisterFour.background = resources.getDrawable(R.drawable.unselected_background)
        binding.v1.setBackgroundColor(resources.getColor(R.color.buttonColor))
        binding.v2.setBackgroundColor(resources.getColor(R.color.etColor))
        binding.v3.setBackgroundColor(resources.getColor(R.color.etColor))
        binding.llOne.visibility=View.GONE
        binding.llTwo.visibility=View.VISIBLE
        binding.llThree.visibility=View.GONE
        binding.llFour.visibility=View.GONE
    }
    fun showLayoutThree(){
        currentLayout=3
        binding.tvRegisterOne.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterTwo.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterThree.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterFour.background = resources.getDrawable(R.drawable.unselected_background)
        binding.v1.setBackgroundColor(resources.getColor(R.color.buttonColor))
        binding.v2.setBackgroundColor(resources.getColor(R.color.buttonColor))
        binding.v3.setBackgroundColor(resources.getColor(R.color.etColor))
        binding.llOne.visibility=View.GONE
        binding.llTwo.visibility=View.GONE
        binding.llThree.visibility=View.VISIBLE
        binding.llFour.visibility=View.GONE
    }
    fun showLayoutFour(){
        currentLayout=4
        binding.tvRegisterOne.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterTwo.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterThree.background = resources.getDrawable(R.drawable.selected_background)
        binding.tvRegisterFour.background = resources.getDrawable(R.drawable.selected_background)
        binding.v1.setBackgroundColor(resources.getColor(R.color.buttonColor))
        binding.v2.setBackgroundColor(resources.getColor(R.color.buttonColor))
        binding.v3.setBackgroundColor(resources.getColor(R.color.buttonColor))
        binding.llOne.visibility=View.GONE
        binding.llTwo.visibility=View.GONE
        binding.llThree.visibility=View.GONE
        binding.llFour.visibility=View.VISIBLE
    }

}