package com.example.jyepezmusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.jyepezmusicapp.models.Album
import com.example.jyepezmusicapp.ui.theme.rubikFontFamily
import com.example.jyepezmusicapp.ui.theme.rubikTextStyles

@Composable
fun AlbumCardRowBox(
    album: Album,
    onClick :() -> Unit
) {
    Box(
        modifier = Modifier
            .size(230.dp)
            .padding(end = 10.dp)
            .clip(RoundedCornerShape(30.dp))
            .shadow(15.dp)
            .background(Color.White)
            .clickable{
                onClick()
            }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = album.image,
            contentDescription = album.title,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(0.75f))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = album.title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = rubikTextStyles.titleCardRow
                        )
                        Text(
                            text = album.artist,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = rubikTextStyles.artistCardRow
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}