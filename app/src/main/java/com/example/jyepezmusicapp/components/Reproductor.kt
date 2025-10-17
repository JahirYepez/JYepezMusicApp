package com.example.jyepezmusicapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.jyepezmusicapp.models.Album

@Composable
fun Reproductor(album: Album){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Black)
    ) {
        // IMAGEN ALBUM
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(50.dp)
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
                .padding(vertical = 10.dp)
                .weight(5f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = album.title,
                color = Color.White,
                // STYLE
            )
            Text(
                text = album.artist,
                color = Color.White
                // STYLE
            )
        }
        Box(
            modifier = Modifier
                .padding(end = 18.dp)
                .align(Alignment.CenterVertically)
                .size(30.dp)
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