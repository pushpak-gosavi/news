package com.pushpak.newssdk.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pushpak.mynews.models.Source

@Composable
fun NewsCard(data: Source) {
    val localUriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .background(Color.LightGray)
            .fillMaxWidth()
    ) {
        Text(text = data.name, modifier = Modifier.padding(5.dp))
        Text(
            text = data.description, modifier = Modifier.padding(5.dp),
            maxLines = 2, overflow = TextOverflow.Ellipsis
        )
        ClickableText(text = buildAnnotatedString {
            this.append(data.url)
        }, style = TextStyle(color = Color.Blue), modifier = Modifier.padding(5.dp), onClick = {
            localUriHandler.openUri(data.url)
        })
    }
}

@Preview(showSystemUi = true)
@Composable
fun NewsCardPreview() {

    NewsCard(
        data = Source(
            category = "Category",
            country = "In",
            description = "Helooo",
            id = "apb_news",
            name = "ABP News",
            language = "EN",
            url = "www.abpnews.com"
        )
    )
}