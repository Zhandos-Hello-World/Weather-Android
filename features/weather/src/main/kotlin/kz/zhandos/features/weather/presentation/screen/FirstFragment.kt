package kz.zhandos.features.weather.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kz.zhandos.features.weather.databinding.FragmentFirstBinding
import kz.zhandos.lib.coreui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : BaseFragment<FirstViewModel, FragmentFirstBinding>() {
    override val viewModel: FirstViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentFirstBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.button.setOnClickListener {
            viewModel.navigateToSecondPage()
        }
    }
}