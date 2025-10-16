package com.example.jyepezmusicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jyepezmusicapp.models.Album

@Composable
fun Albums(
    albums: List<Album>,
    onAlbumClick: (Album) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Albums",
            color = Color.White
            //Style
        )
        Text(
            text = "See more...",
            color = Color.White
            //Style
        )
    }
    LazyRow(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        items(albums){ album ->
            AlbumCardRowBox(
                album = album,
                onClick ={
                    onAlbumClick(album)
                }
            )
        }
    }
}