package kz.zhandos.weatherandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import kz.zhandos.lib.core.events.SystemEvent
import kz.zhandos.lib.core.message.MessageEvent
import kz.zhandos.lib.coreui.R
import kz.zhandos.lib.coreui.ext.showAlert
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.collectMessage()
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect(::handleEvents)
            }
        }
    }

    private fun handleEvents(event: SystemEvent) {
        when (event) {
            is MessageEvent -> {
                showAlert(event)
            }
        }
    }
}
