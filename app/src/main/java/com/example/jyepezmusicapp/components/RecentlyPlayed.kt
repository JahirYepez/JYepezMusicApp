package com.example.jyepezmusicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jyepezmusicapp.models.Album

@Composable
fun RecentlyPlayed(
    albums: List<Album>,
    onAlbumClick: (Album) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Recently Played",
            color = Color.White
            //Style
        )
        Text(
            text = "See more...",
            color = Color.White
            //Style
        )
    }
    LazyColumn(
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        items(albums){ album ->
            AlbumCardColumnBox(
                album = album,
                onClick = {
                    onAlbumClick(album)
                }
            )
        }
    }
}