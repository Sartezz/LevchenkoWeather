package com.example.openweather.ui.mvvm.weatherInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.openweather.R
import com.example.openweather.app.App
import com.example.openweather.databinding.WeatherInfoFragmentBinding
import kotlinx.android.synthetic.main.weather_info_fragment.*
import javax.inject.Inject

class WeatherInfoFragment : Fragment() {
    @Inject
    lateinit var weatherInfoViewModelFactory: WeatherInfoViewModelFactory
    private lateinit var viewModel: WeatherInfoViewModel
    private lateinit var swipeToRefresh: SwipeRefreshLayout
    private lateinit var binding: WeatherInfoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, weatherInfoViewModelFactory)
            .get(WeatherInfoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.weather_info_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_view.visibility = View.INVISIBLE
        swipeToRefresh = swipe_to_refresh

        if (savedInstanceState == null) getWeatherInfo()

        swipeToRefresh.setOnRefreshListener {
            refreshWeatherInfo()
        }

        binding.viewModel = viewModel
    }

    private fun getWeatherInfo() {
        viewModel.getWeatherInfo(
            { },
            { Toast.makeText(context, R.string.error_text, Toast.LENGTH_LONG).show() })
    }

    private fun refreshWeatherInfo() {
        viewModel.getWeatherInfo(
            { },
            { Toast.makeText(activity, R.string.error_text, Toast.LENGTH_LONG).show() })
    }

    companion object {
        fun newInstance(key: String): WeatherInfoFragment {
            val bundle = Bundle()
            bundle.putString("KEY", key)
            val fragment = WeatherInfoFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}