package com.example.roomcronoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomcronoapp.navigation.NavManager
import com.example.roomcronoapp.ui.theme.RoomCronoAppTheme
import com.example.roomcronoapp.viewModels.CronometroViewModel
import com.example.roomcronoapp.viewModels.CronosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //segun el profesor es necesario al utilizar drager y hilt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cronometroVM: CronometroViewModel by viewModels()
        val cronosVM: CronosViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            RoomCronoAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    NavManager(cronometroVM, cronosVM)
                }

            }
        }
    }
}
