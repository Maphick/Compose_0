package com.example.compose_0.domain

data class StatisticItem(
    val type: StatisticType,
    val count: Int =0

)

enum class StatisticType {
    VIEWS, COMMENTS, SHARED, LIKES
}
