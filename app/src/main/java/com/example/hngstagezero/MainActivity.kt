package com.example.hngstagezero

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hngstagezero.ui.theme.HNGStageZeroTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HNGStageZeroTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {Text(text = "HNG Stage Zero", fontWeight = FontWeight.Bold)},
                            modifier = Modifier.padding(8.dp)
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Home(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current

        Text(
            text = "This is the first task of HNG12",
            modifier = modifier.padding(16.dp)
        )


        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/BabaseunSylvester/HNGStageZero"))
                context.startActivity(intent)
            },
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Open GitHub Repository"
            )
        }


        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hng.tech/hire/kotlin-developers"))
                context.startActivity(intent)
            },
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Hire Kotlin Developers"
            )
        }


    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun GreetingPreview() {
    HNGStageZeroTheme {
        Home()
    }
}