package com.example.planetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planetapp.ui.theme.PlanetAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: PlanetViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlanetAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding) ){
                        PlanetList(viewModel)
                    }
                }
            }
        }
    }
}



@Composable
fun PlanetList(viewModel: PlanetViewModel){
    val data  = viewModel.data.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.getData()
    }

    if (!data.value.isNullOrEmpty()) {
        val planets = data.value as List<Planet>

        LazyColumn {
            items(planets) {
                Row(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(10.dp)
                ) {
                    Image(painterResource(it.image), it.name)
                    Column(
                        Modifier
                            .padding(14.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            it.name,
                            fontSize = 24.sp
                        )
                        Text(
                            it.moonCount,
                            fontSize = 14.sp
                        )

                    }
                }
                HorizontalDivider(
                    Modifier
                        .fillParentMaxWidth()
                        .padding(4.dp))
            }
        }
    }


}