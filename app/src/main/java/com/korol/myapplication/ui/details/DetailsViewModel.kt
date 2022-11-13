package com.korol.myapplication.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide.init
import com.korol.domain.details.DetailsInteractor
import com.korol.myapplication.common.BaseViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DetailsViewModel @AssistedInject constructor(
    private val detailsInteractor: DetailsInteractor,
    @Assisted productId: Int
) : BaseViewModel<DetailsState>(DetailsState()) {

    @AssistedFactory
    interface DetailsViewModelFactory {
        fun create(productId: Int): DetailsViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun providesFactory(
            assistedFactory: DetailsViewModelFactory,
            productId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create (modelClass: Class <T>) : T {
                return assistedFactory.create(productId) as T
            }
        }
    }

    init {
        Log.d("my_tag", "viewmodel get productId = $productId")
    }

    fun hello() {
        Log.d("my_tag", "viewModel hello")
    }
}