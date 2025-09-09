package br.edu.up.desafio.presentation.settings

import DropdownDemo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.desafio.data.ColorItem

// Supondo que suas classes de dados sejam assim para o exemplo funcionar
data class User(
    var nome: String,
    val configuration: UserConfiguration = UserConfiguration()
)
data class UserConfiguration(
    var corNome: ColorItem = itemsCor[0] // Cor padrão
)

val itemsCor = listOf(
    ColorItem("Azul", Color.Blue),
    ColorItem("Vermelho", Color.Red),
    ColorItem("Verde", Color.Green),
    ColorItem("Amarelo", Color.Yellow)
)

@Composable
fun ConfiguracoesScreen(user: br.edu.up.desafio.presentation.settings.User) {
    
    var nome by remember { mutableStateOf(user.nome) }
    var corSelecionadaNome by remember { mutableStateOf(user.configuration.corNome) }

    Column(modifier = Modifier.fillMaxSize()) {
        // 2. Layout corrigido: usei uma Column para o cabeçalho
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(10.dp)
        ) {
            Text(
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                text = "CONFIGURAÇÕES"
            )

        }

        Column {
            TextField(
                value = nome,
                label = { Text(text = "Nome de Usuário") },
                onValueChange = { novoValor ->
                    nome = novoValor
                }
            )
            DropdownDemo(
                ddmName = "Cores",
                items = itemsCor,
                selectedItem = corSelecionadaNome,
                onItemSelected = { novaCor: ColorItem ->
                    corSelecionadaNome = novaCor
                }
            )
        }

        // Futuramente, você adicionaria um botão de "Salvar" aqui.
        // Ao clicar, você chamaria uma função (ex: onSave(nome, corSelecionadaNome))
        // que seria responsável por atualizar o objeto 'user' original.
    }
}

@Preview(showBackground = true)
@Composable
fun ConfiguracoesScreenPreview() {
    // Crie um usuário de exemplo com uma configuração
    val sampleUser = User(
        nome = "Usuário Teste",
        configuration = UserConfiguration(corNome = itemsCor[1]) // Vermelho
    )
    ConfiguracoesScreen(user = sampleUser)
}