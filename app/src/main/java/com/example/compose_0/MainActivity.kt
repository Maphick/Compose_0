package com.example.compose_0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_0.ui.theme.Compose_0Theme
import com.example.compose_0.ui.theme.InstagramProfileCard
import com.example.compose_0.ui.theme.PostCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_0Theme {
                Box(
                    modifier = Modifier.fillMaxSize()
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme
                            .background)
                ) {
                   //InstagramProfileCard()
                    PostCard()
                }
            }
        }
    }
}


@Preview
@Composable
fun TestImage()
{
    Image(
        modifier = Modifier.clip(CircleShape),
        painter = painterResource(id = R.drawable.__116670),
        contentDescription = "",
        contentScale = ContentScale.FillHeight
    )
}


@Composable
fun TestText() {
    Column {
        Text(
            text ="fgvdfsbfdsgbfgsbfgbfgb",
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            textDecoration = TextDecoration.combine(listOf(TextDecoration.LineThrough, TextDecoration.Underline))
        )
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Hello")
                }
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(" ")
                }
                withStyle(
                    SpanStyle(
                        fontSize = 30.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                ) {
                    append("World")
                }
                append("!")

            }
        )

    }
}
