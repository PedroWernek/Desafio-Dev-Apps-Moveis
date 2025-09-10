package br.edu.up.desafio.presentation.settings

import DropdownDemo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.navOptions
import br.edu.up.desafio.domain.ColorItem
import br.edu.up.desafio.domain.User


val itemsCor = listOf(
    ColorItem("Azul", Color.Blue),
    ColorItem("Vermelho", Color.Red),
    ColorItem("Verde", Color.Green),
    ColorItem("Amarelo", Color.Yellow)
)

@Composable
fun ConfiguracoesScreen(navController: NavController,user: User) {

    var nome by remember { mutableStateOf(user.nome) }
    var corSelecionadaNome by remember { mutableStateOf(user.configuration.corNome) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(10.dp)

        ) {
            IconButton(onClick = {navController.popBackStack()}) { Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = Color.White) }
            Text(
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                text = "CONFIGURAÇÕES"
            )

        }

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nome,
                label = { Text(text = "Nome de Usuário") },
                onValueChange = { novoValor ->
                    nome = novoValor
                }
            )
            DropdownDemo(
                ddmName = "Cor Nome",
                items = itemsCor,
                selectedItem = corSelecionadaNome,
                onItemSelected = { novaCor: ColorItem ->
                    corSelecionadaNome = novaCor
                }
            )
            DropdownDemo(
                ddmName = "Cor Fundo",
                items = itemsCor,
                selectedItem = corSelecionadaNome,
                onItemSelected = { novaCor: ColorItem ->
                    corSelecionadaNome = novaCor
                }
            )
        }
    }
}
