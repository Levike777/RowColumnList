package com.example.rowcolumnlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowcolumnlist.ui.theme.RowColumnListTheme
import kotlin.random.Random
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowColumnListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Oszlop(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable

fun Oszlop(modifier: Modifier = Modifier) {
    var red by remember { mutableIntStateOf(0) }
    var green by remember { mutableIntStateOf(0) }
    var blue by remember { mutableIntStateOf(0) }

    var osszeg by remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(red, green, blue)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            Slider(

                value = red.toFloat(),
                enabled = true,
                onValueChange = { red = it.toInt() },
                valueRange = 0f..255f,


                )
        }
        Column {
            Slider(

                value = green.toFloat(),
                enabled = true,
                onValueChange = { green = it.toInt() },
                valueRange = 0f..255f,


                )
        }
        Column {
            Slider(

                value = blue.toFloat(),
                enabled = true,
                onValueChange = { blue = it.toInt() },
                valueRange = 0f..255f,


                )
        }

        Text(
            color = when {
                osszeg < 200 -> Color.White
                osszeg > 200 -> Color.Black
                else -> Color.Black
            },
            fontSize = 25.sp,
            text = "($red, $green, $blue)"
        )
        Spacer(Modifier.height(height = 16.dp))
        Button(
            onClick = {
                red = Random.nextInt(256)
                green = Random.nextInt(256)
                blue = Random.nextInt(256)
                osszeg = red + green + blue
            }
        ) {
            Text(text = "Random szín generálás")
        }
    }
}




