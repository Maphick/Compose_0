package com.example.compose_0.domain

import com.example.compose_0.R

data class FeedPost(
    val communityName : String = "/dev/null",
    val publicationData: String = "14:00",
    val avatarResId: Int = R.drawable.__116670,
    val contentText: String = "Lorem Ipsum",
    val contentImageResId: Int = R.drawable.__116670,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS ,966),
        StatisticItem(type = StatisticType.SHARED ,966),
        StatisticItem(type = StatisticType.COMMENTS , 966),
        StatisticItem(type = StatisticType.LIKES ,966),
    )
)
