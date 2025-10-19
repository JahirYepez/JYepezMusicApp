package com.example.jyepezmusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.jyepezmusicapp.models.Album
import com.example.jyepezmusicapp.ui.theme.rubikTextStyles

@Composable
fun AlbumCardColumnBox(
    album: Album,
    onClick :() -> Unit
){
    val shape = RoundedCornerShape(20.dp)
    Row(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth()
            .height(90.dp)
            .shadow(30.dp, shape)
            .clip(shape)
            .background(Color.White)
            .clickable{
                onClick()
            }
    ) {
        // IMAGEN ALBUM
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(65.dp)
                .clip(RoundedCornerShape(15.dp))
                .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = album.image,
                contentDescription = album.title,
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .padding(vertical = 15.dp)
                .weight(5f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = album.title,
                style = rubikTextStyles.titleCardColumn,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = "${album.artist} • ${album.description ?: ' '}",
                maxLines = 1,
                style = rubikTextStyles.artistCardColumn
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Mas...",
            modifier = Modifier
                .weight(1f)
                .padding(end = 15.dp)
                .align(Alignment.CenterVertically),
            tint = Color.Black
        )
    }
}