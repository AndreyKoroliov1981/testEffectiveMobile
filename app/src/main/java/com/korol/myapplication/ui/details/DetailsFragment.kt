package com.korol.myapplication.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.korol.myapplication.R
import com.korol.myapplication.app.App
import com.korol.myapplication.databinding.FragmentDetailsBinding
import com.korol.myapplication.ui.home.HomeViewModel
import com.korol.myapplication.ui.home.HomeViewModelFactory

class DetailsFragment: Fragment(R.layout.fragment_details) {
    private val viewBinding: FragmentDetailsBinding by viewBinding()

    private val args: DetailsFragmentArgs by navArgs()

    @javax.inject.Inject
    lateinit var vmFactory: DetailsViewModel.DetailsViewModelFactory

    private val viewModel: DetailsViewModel by viewModels{
        DetailsViewModel.providesFactory(
            assistedFactory = vmFactory,
            productId = args.productId
        )
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectDetailsFragment(this)
        viewModel.hello()
    }

}