package br.edu.up.desafio.presentation.boas_vindas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.desafio.domain.User

@Composable
fun BoasVindasScreen(navController: NavController, user: User) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = user.configuration.corFundo.cor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Bem Vindo(a)\n\n${user.nome}", fontSize = 30.sp, color = user.configuration.corNome.cor)
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = {
                navController.navigate("configuracoes")
            }) {
                Text(text = "Configurações")
            }
        }

    }
}