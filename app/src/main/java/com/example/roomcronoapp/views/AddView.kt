package com.example.roomcronoapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.roomcronoapp.R
import com.example.roomcronoapp.components.CircleButton
import com.example.roomcronoapp.components.FloatButton
import com.example.roomcronoapp.components.MainIconButton
import com.example.roomcronoapp.components.MainTitle
import com.example.roomcronoapp.components.formatTiempo
import com.example.roomcronoapp.viewModels.CronometroViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(navController: NavController, cronometroVM: CronometroViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "ADD CRONO APP") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        },
    ) {
        ContentAddView(it, navController, cronometroVM)
    }
}

@Composable
fun ContentAddView(it: PaddingValues, navController: NavController, cronometroVM: CronometroViewModel) {

    val state = cronometroVM.state

    LaunchedEffect(state.cronometroActivo) {
        cronometroVM.cronos()
    }

    Column (
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = formatTiempo(tiempo = cronometroVM.tiempo),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
        )

        Row (horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            //iniciar
            CircleButton(
                icon = painterResource(id = R.drawable.play),
                enabled = !state.cronometroActivo
            ) {
                cronometroVM.iniciar()
            }

            //pausar
            CircleButton(
                icon = painterResource(id = R.drawable.pause),
                enabled = state.cronometroActivo
            ) {
                cronometroVM.pausar()
            }

            //detener
            CircleButton(
                icon = painterResource(id = R.drawable.stop),
                enabled = !state.cronometroActivo
            ) {
                cronometroVM.detener()
            }

            //mostrar guardar
            CircleButton(
                icon = painterResource(id = R.drawable.save),
                enabled = state.showSaveButton
            ) {
                cronometroVM.showTextField()
            }

        }
    }
}