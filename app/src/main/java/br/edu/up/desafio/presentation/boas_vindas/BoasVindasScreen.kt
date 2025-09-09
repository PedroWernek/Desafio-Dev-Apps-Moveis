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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.desafio.data.AppConfiguration
import br.edu.up.desafio.data.User
import br.edu.up.desafio.presentation.settings.itemsCor

@Composable
fun BoasVindasScreen(user: User) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = user.configuration.corFundo),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Bem Vindo(a)\n\n${user.nome}", fontSize = 30.sp, color = user.configuration.corNome)
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = {}) {
                Text(text = "Configurações")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BoasVindasScreenPreview() {
    val sampleUser = User(
        nome = "Usuário Teste",
        configuration = AppConfiguration(corNome = Color.Black, corFundo = Color.White)
    )
    BoasVindasScreen(sampleUser)
}