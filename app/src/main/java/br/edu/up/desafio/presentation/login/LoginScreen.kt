package br.edu.up.desafio.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.desafio.domain.User

@Composable
fun LoginScreen(navController: NavController, user: User) {

    var nomeUsuario by remember {
            mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = { nomeUsuario = it},
                label = { Text(text = "Nome") },
                )
/*            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Email") })
            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Senha") })*/
            Button(onClick = {
                user.nome = nomeUsuario
                navController.navigate("boas_vindas")
            }) { Text(text = "Entrar")}
        }

    }
}
