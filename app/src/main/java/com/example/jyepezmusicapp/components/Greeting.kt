package com.example.jyepezmusicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ICONOS
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu",
                    tint = Color.White,
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "buscar",
                    tint = Color.White
                )
            }
        }
    }
    Text(
        modifier = Modifier.padding(horizontal = 15.dp),
        text = "Buenos días!",
        color = Color.White
        // STYLE BUENOS DIAS
    )
    Text(
        modifier = Modifier.padding(horizontal = 15.dp),
        text = "Jahir Yépez",
        color = Color.White
        // STYLE NOMBRE
    )
}