package br.edu.up.desafio.domain

import androidx.compose.ui.graphics.Color

class User(
    var nome: String,
    var configuration: AppConfiguration = AppConfiguration(ColorItem("Preto",Color.Black), ColorItem("Branco",Color.White))
)