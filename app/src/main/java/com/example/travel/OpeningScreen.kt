package com.example.travel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun OpeningScreen(OnNextTela: () -> Unit){
    val radial =  Brush.verticalGradient(listOf(Color(0xFF0172B2), Color(0xFF001645)))
    val lobster = FontFamily(Font(R.font.lobster, FontWeight.Normal))
    val robotoMedium = FontFamily(Font(R.font.roboto_medium))
    Column(
        Modifier
            .fillMaxSize()
            .background(radial)
            .systemBarsPadding().clickable { OnNextTela() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "Travel", fontFamily = lobster, color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Normal)
            Icon(
                painter = painterResource(id = R.drawable.globe_icon),
                contentDescription = null,
                tint = Color.White
            )
        }
        Box(){
            Text(text = "Find Your Dream \n Destination With Us", fontFamily = robotoMedium, color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.width(250.dp))
        }
    }
}