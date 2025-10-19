package com.example.jyepezmusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jyepezmusicapp.components.AlbumDetailImage
import com.example.jyepezmusicapp.components.AlbumListCard
import com.example.jyepezmusicapp.components.Reproductor
import com.example.jyepezmusicapp.models.Album
import com.example.jyepezmusicapp.services.AlbumService
import com.example.jyepezmusicapp.ui.theme.HomeBackgroundGradiant
import com.example.jyepezmusicapp.ui.theme.rubikTextStyles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AlbumDetailScreen(id: String, navController: NavController) {
    var album by remember {
        mutableStateOf<Album?>(null)
    }
    var loading by remember {
        mutableStateOf(true)
    }
    Log.i("AlbumDetailScreen", "ID: '$id'")
    LaunchedEffect(id) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = withContext(Dispatchers.IO){
                service.getAlbumById(id)
            }
            album = result
            loading = false
            Log.i("AlbumDetailScreen", album.toString())
        }
        catch (e: Exception){
            loading = false
            Log.e("AlbumDetailScreen", e.toString())
        }
    }
    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(HomeBackgroundGradiant),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(HomeBackgroundGradiant)
                .padding(
                    horizontal = 20.dp,
                    vertical = 35.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(3f)
            ) {
                AlbumDetailImage(album, navController)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 15.dp
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 15.dp,
                                top = 12.dp,
                                end = 15.dp,
                                bottom = 5.dp
                            ),
                        text = "About this album...",
                        style = rubikTextStyles.aboutThis
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 15.dp,
                                end = 15.dp,
                                bottom = 12.dp
                            ),
                        text = album?.description?:"",
                        style = rubikTextStyles.description
                    )
                }
                Row (
                    modifier = Modifier
                        //.fillMaxWidth()
                        .padding(
                            bottom = 20.dp
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 15.dp,
                                top = 12.dp,
                                bottom = 12.dp
                            ),
                        text = "Artist:",
                        style = rubikTextStyles.aboutThis
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 5.dp,
                                top = 12.dp,
                                end = 15.dp,
                                bottom = 12.dp
                            ),
                        text = album?.artist?:"",
                        style = rubikTextStyles.description
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column {
                        //SI NO ES NULLEABLE
                        album?.let { safeAlbum ->
                            AlbumListCard(album = safeAlbum)
                        }
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    ) {
                        album?.let { safeAlbum ->
                            Reproductor(album = safeAlbum)
                        }
                    }
                }
            }
        }
    }
}