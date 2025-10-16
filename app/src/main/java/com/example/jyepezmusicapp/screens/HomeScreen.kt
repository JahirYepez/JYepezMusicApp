package com.example.jyepezmusicapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.jyepezmusicapp.components.Albums
import com.example.jyepezmusicapp.components.Greeting
import com.example.jyepezmusicapp.models.Album
import com.example.jyepezmusicapp.services.AlbumService
import com.example.jyepezmusicapp.ui.theme.AlbumDetailScreenRoute
import com.example.jyepezmusicapp.ui.theme.HomeBackgroundGradiant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(
    navController: NavController
) {
    var albums by remember {
        mutableStateOf(listOf<Album>())
    }
    var loading by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)
            val result = async(Dispatchers.IO) {
                service.getAllAlbums()
            }
            Log.i("HomeSreen", "${result.await()}")
            albums = result.await()
            loading = false
        }
        catch (e: Exception) {
            loading = false
            Log.e("HomeScreen", e.toString())
        }
    }
    if (loading){
        Box(
            modifier = Modifier
                .fillMaxSize(),
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
                    //.padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    // COLOR GREETING -------
                    .background(Color.Red)
            ) {
                Greeting()
            }
            //
            Column(
                modifier = Modifier
                    .weight(5f)
                    .padding(vertical = 8.dp)
            ) {
                Albums(
                    albums = albums,
                    onAlbumClick = { album ->
                        navController.navigate(AlbumDetailScreenRoute(album.id.toString()))
                    }
                )
            }
        }
    }
}