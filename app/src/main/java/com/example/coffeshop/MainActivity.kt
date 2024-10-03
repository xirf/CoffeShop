package com.example.coffeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeshop.model.Menu
import com.example.coffeshop.model.dummyBestSellerMenu
import com.example.coffeshop.model.dummyCategory
import com.example.coffeshop.model.dummyMenu
import com.example.coffeshop.ui.components.CategoryItem
import com.example.coffeshop.ui.components.HomeSection
import com.example.coffeshop.ui.components.MenuItem
import com.example.coffeshop.ui.components.Search
import com.example.coffeshop.ui.components.SectionText
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
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Banner()
        HomeSection(
            title = stringResource(R.string.section_category),
            content = { CategoryRow() }
        )
        HomeSection(stringResource(R.string.section_best_seller_menu), Modifier) {
            MenuRow(dummyMenu)
        }
        HomeSection(stringResource(R.string.section_best_seller_menu)) {
            MenuRow(dummyBestSellerMenu)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) {
            MenuItem(it, modifier = modifier.clipToBounds())
        }
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category, modifier = modifier.fillMaxHeight())
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Coffee Shop",
            contentScale = ContentScale.Crop,
            modifier = modifier.height(160.dp)
        )
        Search()
    }
}


/**
 * ==============================
 * PREVIEW
 * ==============================
 */

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_8_pro")
@Composable
fun CoffeShopAppPreview() {
    CoffeShopTheme {
        CoffeeShopApp()
    }
}
