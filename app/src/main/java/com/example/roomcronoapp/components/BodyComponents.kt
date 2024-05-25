package com.example.roomcronoapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.min


@Composable
fun MainTitle(title: String) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.Bold)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 15.dp)

    )
}

@SuppressLint("DefaultLocale")
@Composable
fun formatTiempo(tiempo: Long): String {
    val segundos = (tiempo / 1000) % 60
    val minutos = (tiempo / 1000 / 60) % 60
    val horas = tiempo / 1000 / 360

    return String.format("%02d:%02d:%02d", horas, minutos, segundos)
}