package com.example.jyepezmusicapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jyepezmusicapp.R

// Set of Material typography styles to start with

val rubikFontFamily = FontFamily(
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_light, FontWeight.Light),
    Font(R.font.rubik_italic, FontWeight.Normal, FontStyle.Italic)
)

object rubikTextStyles {
    val goodMorning = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 19.sp,
        letterSpacing = (0.5).sp
    )

    val name = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        letterSpacing = (0.4).sp
    )

    val albumsRecently = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black
    )
    val seeMore = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = (0.3).sp
    )

    val titleCardRow = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        color = Color.Black
    )

    val artistCardRow = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
        color = Color.Black
    )

    val titleCardColumn = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        color = Color.Black
    )

    val artistCardColumn = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = Color.Black
    )

    val titlePlayer = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.White
    )

    val artistPlayer = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        color = Color.White
    )

    val titleDetailAlbum = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        color = Color.White
    )

    val artistDetailAlbum = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = Color.White
    )

    val aboutThis = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.Black
    )

    val description = TextStyle(
        fontFamily = rubikFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black
    )
}

val rubikTypo = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // buenosDias

    // nombre

    // album / recently played

    // see more

    // album.title

    // album.artist


)