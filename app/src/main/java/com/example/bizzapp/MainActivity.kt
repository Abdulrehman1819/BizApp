package com.example.bizzapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizzapp.ui.theme.BizzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizzAppTheme {
                CreateBizzCard()
            }
        }
    }
}

@Composable
fun CreateBizzCard() {
    var buttonClicked by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Card(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxSize(),
//                .width(200.dp)
//                .height(300.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(30.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Column(
                modifier = Modifier
//                    .height(300.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider(
                    thickness = 0.5.dp,
                    color = Color.DarkGray
                )
                CreateInfo()
                Button(onClick = {
                    buttonClicked = !buttonClicked
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                if (buttonClicked) {
                    Content()

                } else {
                    Box() {

                    }
                }
            }

        }
    }
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project1", "Project2"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { it ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.LightGray),
                shape = RectangleShape
            ) {
                Row (
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color = MaterialTheme.colorScheme.surface),
                ){
                   CreateImageProfile()
                    Column(
                    ) {
                        Text(text = it)
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Abdul Rehman Athar", color = Color.Blue,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Android JetPack Compose Programmer", modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = "@bdulrehman@gmail.com", modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
private fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.DarkGray),
        shadowElevation = 10000.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image"
        )
    }
}
