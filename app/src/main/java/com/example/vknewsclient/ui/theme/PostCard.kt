package com.example.vknewsclient.ui.theme

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R
import kotlinx.coroutines.processNextEventInCurrentThread

//@Preview
@Composable
fun PostCard() {
    Card {
        Column(modifier = Modifier
            .padding(8.dp)
        ) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(R.string.template_text))
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.post_content_image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics()
        }
    }
}
@Composable
private fun Statistics(){
    Row() {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
           IconWithText(iconResId = R.drawable.ic_views_count, text = "345" )
        }
        Row(modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
          IconWithText(iconResId = R.drawable.ic_share, text = "77")
          IconWithText(iconResId = R.drawable.ic_comment, text = "33")
          IconWithText(iconResId = R.drawable.ic_like, text = "154")
        }
    }
}

@Composable
private fun IconWithText(iconResId: Int, text: String){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
            )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text,
            color = MaterialTheme.colorScheme.onSecondary)
    }
}

@Composable
private fun PostHeader() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
               // .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
                painter = painterResource(id = R.drawable.post_comunity_thumbnail),
                contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)

            ){
                Text(text = "dev/null",
                    color = MaterialTheme.colorScheme.onPrimary)
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "23:00",
                    color = MaterialTheme.colorScheme.onSecondary)
            }
            Icon ( imageVector = Icons.Rounded.MoreVert,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }


@Preview
@Composable
 private fun PreviewCardLight() {
    VkNewsClientTheme(
        darkTheme = false
    ) {
        PostCard()
    }

}

@Preview
@Composable
private fun PreviewCardDark() {
    VkNewsClientTheme (
        darkTheme = true
    ) {
        PostCard()
    }
}
