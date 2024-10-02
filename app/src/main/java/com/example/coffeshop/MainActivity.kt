package com.example.coffeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeshop.ui.components.Search
import com.example.coffeshop.ui.theme.CoffeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeShopTheme {
                CoffeeShopApp()
            }
        }
    }
}

@Composable
fun CoffeeShopApp(modifier: Modifier = Modifier) {
    Column {
        Banner()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier){
    Box(modifier = modifier){
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Coffee Shop",
            contentScale = ContentScale.Crop,
            modifier = modifier.height(160.dp)
        )
        Search()
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_8_pro")
@Composable
fun CoffeShopAppPreview() {
    CoffeShopTheme {
        CoffeeShopApp()
    }
}