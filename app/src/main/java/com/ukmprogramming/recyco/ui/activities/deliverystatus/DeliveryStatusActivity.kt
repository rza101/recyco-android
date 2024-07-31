package com.ukmprogramming.recyco.ui.activities.deliverystatus

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ukmprogramming.recyco.data.network.response.models.MarketItem
import com.ukmprogramming.recyco.data.network.response.models.MarketTransactionsItem
import com.ukmprogramming.recyco.databinding.ActivityDeliveryStatusBinding
import com.ukmprogramming.recyco.util.Helpers
import com.ukmprogramming.recyco.util.MarketTransactionStatuses
import com.ukmprogramming.recyco.util.ResultState
import com.ukmprogramming.recyco.util.handleHttpException
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeliveryStatusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeliveryStatusBinding
    private val viewModel by viewModels<DeliveryStatusViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeliveryStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val marketItemId = intent.getStringExtra(EXTRA_MARKET_ITEM_ID_KEY) ?: run {
            finish()
            return
        }

        binding.apply {
            viewModel.marketTransactionDataState.observe(this@DeliveryStatusActivity) { resultState ->
                progressBar.isVisible = resultState is ResultState.Loading

                if (resultState is ResultState.Success) {
                    tvProductName.text = resultState.data.item.name
                    tvProductWeight.text = resultState.data.item.weight.toString()
                    tvProductPrice.text = resultState.data.item.price.toString()

                    val onProcessStatus = resultState.data.allStatus.firstOrNull {
                        it.status == MarketTransactionStatuses.ON_PROCESS.name
                    }
                    val onDeliverStatus = resultState.data.allStatus.firstOrNull {
                        it.status == MarketTransactionStatuses.ON_DELIVER.name
                    }
                    val finishedStatus = resultState.data.allStatus.firstOrNull {
                        it.status == MarketTransactionStatuses.FINISHED.name
                    }

                    tvOrderTime.text =
                        onProcessStatus?.createdAt?.let { Helpers.formatDate(it) } ?: "-"
                    tvDeliver.text =
                        onDeliverStatus?.createdAt?.let { Helpers.formatDate(it) } ?: "-"
                    tvComplete.text =
                        finishedStatus?.createdAt?.let { Helpers.formatDate(it) } ?: "-"
                } else if (resultState is ResultState.Error) {
                    resultState.exception.getData()
                        ?.handleHttpException(this@DeliveryStatusActivity)
                        ?.let { message ->
                            Toast.makeText(this@DeliveryStatusActivity, message, Toast.LENGTH_SHORT)
                                .show()
                        }
                }
            }
        }

        viewModel.getMarketTransactionById(marketItemId)
    }

    companion object {
        const val EXTRA_MARKET_ITEM_ID_KEY = "EXTRA_MARKET_ITEM_ID_KEY"
    }
}