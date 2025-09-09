package br.edu.up.desafio.data

import androidx.compose.ui.graphics.Color

class User(
    var nome: String,
    var configuration: AppConfiguration = AppConfiguration(Color.Black, Color.White)
)