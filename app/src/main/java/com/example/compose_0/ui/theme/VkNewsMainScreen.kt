package com.example.compose_0.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose_0.MainViewModel
import com.example.compose_0.domain.FeedPost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val feedPost = mainViewModel.feedPost.observeAsState(FeedPost())

    //val feedPost = remember { // чтобы PostCard была вызвана уже с новыми значениями
       // mutableStateOf(FeedPost())

    PostCard(
        modifier = Modifier.padding(8.dp),
        feedPost = feedPost.value,
        onStatisticsItemClickListener = {
            mainViewModel.updateCount(it)
        }
        /*
        onStatisticsItemClickListener = {newItem -> // изменить значение статистики, чтобы произошла рекомпозиция
            val oldStatistics = feedPost.value.statistics
            val newStatistics = oldStatistics.toMutableList().apply {
                    replaceAll { oldItem ->// заменить все элементы
                        if (oldItem.type == newItem.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        }
                        else {
                            oldItem
                        }
                    }
            }
            feedPost.value = feedPost.value.copy(statistics = newStatistics)
        }
        */
    )

}

