package com.example.cat_compouse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatList()
        }
    }
}


// СОЗДАЕМ ОДНУ КАРТОЧКУ КОТА
@Composable
fun Cat(imageIndex: Int) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .size(132.dp, 132.dp)


    ) {
        Column(
            modifier = Modifier.background(Color.Transparent),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(105.dp)
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(imageIndex),
                    contentDescription = "",
                    modifier = Modifier.padding(10.dp)
                )
            }
            Text(text = "The Cat", fontWeight = FontWeight.Bold)
        }
    }
}


// СОЗДАЕМ ЛИСТ КОТИКОВ
@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatList() {
    val catImagePath = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5,
        R.drawable.cat_6,
    )

    var count by remember { mutableStateOf(0) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            content = {
                items(count = count) { i ->
                    Cat(catImagePath[i])

                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                if (count == 6) {
                    count = 0
                }
                count++
            }
        )
        {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "ДОБАВИТЬ КОТИКА"
            )
        }
    }
}

