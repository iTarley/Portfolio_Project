package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.sql.Wrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    androidx.compose.material.Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(14.dp),
            shape = RoundedCornerShape(corner = CornerSize(30.dp)),
            elevation = 100.dp) {

            Column(horizontalAlignment = CenterHorizontally) {
                CreateImageProfile()
                Divider()
                ShowText()
                Button1()
            }
        }
    }
}



@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
private fun ShowText(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Luka N.",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4
        )

        Text(
            text = "Android Student",
            modifier = Modifier.padding(3.dp))
        Text(
            text = "luka.nikuradze.1@btu.edu.ge",
            modifier = Modifier.padding(3.dp))
    }



}

@Composable
private fun Button1(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val check = remember {
        mutableStateOf(value = false)
    }
    Button(onClick = {
        check.value = !check.value
    }) {
        Text(text = "Click Me")
    }

    if (check.value){
        Content()
    }else{
        Box(){}
    }
}



@Composable
private fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)) {

            Portfolio(data= listOf("MetaSSenger","Portfolio Project","Still in Progress"))

        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data){
            item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(), shape = RectangleShape, elevation = 16.dp, border = BorderStroke(width = 2.dp, color = Color.LightGray)) {
                
                Row(modifier = Modifier
                    .padding(7.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    
                    Column(modifier = Modifier.padding(7.dp).align(alignment = CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Nothing to say, it just test")
                    }

                    
                }
                
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CreateBizCard()
    }
}