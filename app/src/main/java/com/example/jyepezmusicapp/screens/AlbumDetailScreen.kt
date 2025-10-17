package com.example.jyepezmusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.jyepezmusicapp.models.Album
import com.example.jyepezmusicapp.services.AlbumService
import com.example.jyepezmusicapp.ui.theme.HomeBackgroundGradiant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AlbumDetailScreen(id: String, navController: NavController) {
    var album by remember {
        mutableStateOf<Album?>(null)
    }
    // Variable para estado en lo que se consume la API
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
                .background(Color.Blue),
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
            }
        }
    }
}