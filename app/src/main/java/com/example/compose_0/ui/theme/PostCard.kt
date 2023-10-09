package com.example.compose_0.ui.theme

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_0.R
import com.example.compose_0.domain.FeedPost
import com.example.compose_0.domain.StatisticItem
import com.example.compose_0.domain.StatisticType
import java.lang.IllegalStateException



    @Composable
    fun PostCard(
        modifier: Modifier = Modifier,
        feedPost: FeedPost,
        onStatisticsItemClickListener: (StatisticItem) -> Unit // слушатель на статистику, т.к. много разных элементов
    ) {
    Card(
        modifier = Modifier.padding(8.dp)
    )
    {
        Column (
            modifier = Modifier.padding(8.dp)
        )
        {
            PostHeader(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = feedPost.contentText,
                color = MaterialTheme.colorScheme.onPrimary
                )

            Spacer(modifier = Modifier.height(8.dp))
            Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = painterResource(id = feedPost.contentImageResId),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics(
                statistics = feedPost.statistics,
                onItemClickListener = onStatisticsItemClickListener
            )
            }

        }
    }



@Composable
private fun PostHeader(
    feedPost: FeedPost
)
{
    Row {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = feedPost.avatarResId),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            // на всю ширину
            modifier = Modifier.weight(1f)
        )
        {
            Text(
                text = feedPost.communityName,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = feedPost.publicationData,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
private fun Statistics(
    statistics: List<StatisticItem>,
    onItemClickListener: (StatisticItem) -> Unit

){
    Row{
        Row(
            modifier = Modifier.weight(1f)
        )
        {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithText(
                iconResId = R.drawable.__116670,
                text = viewsItem.count.toString(),
                onItemClickListener = { // слушатель
                    onItemClickListener(viewsItem) // передаем элемент, по которому произошел клик
                }
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            val sharesItem = statistics.getItemByType(StatisticType.SHARED)
            IconWithText(
                iconResId = R.drawable.__116670,
                text = sharesItem.count.toString(),
                onItemClickListener = { // слушатель
                    onItemClickListener(sharesItem) // передаем элемент, по которому произошел клик
                }
            )
            val commentItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithText(
                iconResId = R.drawable.__116670,
                text = commentItem.count.toString(),
                onItemClickListener = { // слушатель
                    onItemClickListener(commentItem) // передаем элемент, по которому произошел клик
                }
            )
            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithText(
                iconResId = R.drawable.__116670,
                text = likesItem.count.toString(),
                onItemClickListener = { // слушатель
                    onItemClickListener(likesItem) // передаем элемент, по которому произошел клик
                }
            )
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType):StatisticItem {
    return this.find {it.type == type} ?: throw IllegalStateException()
}

@Composable
fun IconWithText(
    iconResId: Int,
    text: String,
    onItemClickListener: () -> Unit // слушатель
) {
 Row(
     modifier = Modifier.clickable {
        onItemClickListener
     },
     verticalAlignment = Alignment.CenterVertically
 )
 {
     Icon(
         painter = painterResource(id = iconResId),
         contentDescription = null,
         tint = MaterialTheme.colorScheme.onSecondary
     )
     Spacer(modifier = Modifier.height(4.dp))
     Text(
         text = text,
         color = MaterialTheme.colorScheme.onSecondary
     )

 }
}

@Composable
fun PreviewLight()
{

}