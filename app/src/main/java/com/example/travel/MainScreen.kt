package com.example.travel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


@Composable
fun MainScreen(){
    Column(
        Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        topBar()
        inputPlaces()
        butonNav()
        cards()
        navBar()
    }
}

@Composable
fun topBar(){
    val montserratSemibold = FontFamily(Font(R.font.montserrat_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.Medium))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp, 15.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Hi, David 🖐️", fontSize = 30.sp, fontFamily = montserratSemibold,  fontWeight = FontWeight.SemiBold)
            Text(text = "Explore the wold", fontSize = 15.sp, fontFamily = interMedium, fontWeight = FontWeight.Medium, color = Color.Gray)
        }
        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = "Foto de perfil",
            Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(50))
//                .border(1.dp, Color.Gray, CircleShape),
                ,contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun inputPlaces(){
    val roboto = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            trailingIcon = {
                Icon( painter = painterResource(id = R.drawable.icon_setting),
                    contentDescription = null,
                    tint = Color(0xff888888))
            },
            shape = RoundedCornerShape(50),
            label = {
                    Text("Change name", fontFamily = roboto, fontSize = 15.sp, color = Color(0xFF888888))
            }
        )
    }
}

@Composable
fun  butonNav(){
    val robotoMedium = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium))
    val poppinsSemibold = FontFamily(Font(R.font.poppins_semibold, FontWeight.SemiBold))
    Column(
        Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp, 15.dp, 0.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Popular places", fontFamily = poppinsSemibold, color = Color(0xFF2F2F2F), fontSize = 20.sp)
            Text(text = "View all", fontFamily = poppinsSemibold, color = Color(0xFF888888), fontSize = 16.sp)
        }

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color(0xFF2F2F2F))) {
                Text(text = "Most Viewed", fontFamily = robotoMedium, color = Color.White, fontSize = 15.sp)
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xFFFBFBFB))) {
                Text(text = "Nearby", fontFamily = robotoMedium, color = Color.Gray, fontSize = 15.sp)
            }
            Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color(0xFFFBFBFB))) {
                Text(text = "Latest", fontFamily = robotoMedium,  color = Color.Gray, fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun cards(){
    val robotoMedium = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium))
    val robotoRegular =  FontFamily(Font(R.font.roboto, FontWeight.Medium))
    val widthCard = 380
    val heightCard = 250
    Row(
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(
            modifier = with (Modifier){
                clip(RoundedCornerShape(30.dp))
                    .height(widthCard.dp)
                    .width(heightCard.dp)
                    .padding(15.dp, 0.dp, 0.dp, 0.dp)
                    .shadow(25.dp)
                    .paint(
                        painterResource(id = R.drawable.card),
                        contentScale = ContentScale.FillBounds
                    )
            }
        ) {
            Box(modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(0.dp,35.dp)
                .height(60.dp)
                .width(170.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Black))
            {
              Column(
                  Modifier.padding(4.dp),
                  horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center
              ) {
                  Text(text = "Mount Fuji, Tokyo", fontFamily = robotoMedium, fontSize = 16.sp, color = Color.White)
                  Row(
                      verticalAlignment = Alignment.Bottom,
                      horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                      Row(){
                          Icon( painter = painterResource(id = R.drawable.loc),
                              contentDescription = null,
                              tint = Color(0xFFCAC8C8))
                          Text(text = "Tokyo, Japan", fontFamily = robotoRegular, fontSize = 14.sp, color = Color(0xFFCAC8C8))
                      }
                      Row {
                          Icon( painter = painterResource(id = R.drawable.star),
                              contentDescription = null,
                              tint = Color(0xFFCAC8C8))
                          Text(text = "4.8", fontFamily = robotoRegular, fontSize = 14.sp, color = Color(0xFFCAC8C8))
                      }
                  }
              }
            }
        }
        Box(
            modifier = with (Modifier){
                clip(RoundedCornerShape(30.dp))
                    .height(widthCard.dp)
                    .width(heightCard.dp)
                    .paint(
                        painterResource(id = R.drawable.card),
                        contentScale = ContentScale.FillBounds
                    )
            }
        ) {

        }
        Box(
            modifier = with (Modifier){
                clip(RoundedCornerShape(30.dp))
                    .height(widthCard.dp)
                    .width(heightCard.dp)
                    .paint(
                        painterResource(id = R.drawable.card),
                        contentScale = ContentScale.FillBounds
                    )
            }
        ) {

        }
    }
}

@Composable
fun navBar(){
    Row(
        Modifier.fillMaxWidth().padding(0.dp,0.dp,0.dp,10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceAround
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_home),
            contentDescription = null,
            tint = Color(0xFF2F2F2F)
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_clock),
            contentDescription = null,
            tint = Color(0xff848282)
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_heart),
            contentDescription = null,
            tint = Color(0xff848282)
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_user),
            contentDescription = null,
            tint = Color(0xff848282)
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun pre(){
////    Ima()
    MainScreen()
//    Img()
//    navBar()
//    topBar()
//    inputPlaces()
}