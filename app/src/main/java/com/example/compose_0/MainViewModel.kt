package com.example.compose_0

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose_0.domain.FeedPost
import com.example.compose_0.domain.StatisticItem

class MainViewModel: ViewModel() {

    // чтобы менять feed post
    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    // метод обновления кол-ва элементов
    fun updateCount(item: StatisticItem) {
        val oldStatistics = feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->// заменить все элементы
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                }
                else {
                    oldItem
                }
            }
        }
        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
    }
}