package br.edu.up.desafio.presentation.boas_vindas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import br.edu.up.desafio.data.User

@Composable
fun BoasVindasScreen(user: User){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {}) {
            Text(text = "Configurações")
        }
        Column {
            Text("Bem Vindo(a)\n${user.nome}")
        }
    }
}