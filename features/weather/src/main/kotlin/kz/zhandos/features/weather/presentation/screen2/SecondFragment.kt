package kz.zhandos.features.weather.presentation.screen2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.zhandos.features.weather.databinding.FragmentSecondBinding
import kz.zhandos.lib.coreui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : BaseFragment<SecondViewModel, FragmentSecondBinding>() {
    override val viewModel: SecondViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentSecondBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.button.setOnClickListener {
            viewModel.back()
        }
    }
}