import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import br.edu.up.desafio.data.ColorItem

@Composable
fun DropdownDemo(
    ddmName: String,
    items: List<ColorItem>,
    selectedItem: ColorItem,
    onItemSelected: (ColorItem) -> Unit // Função de callback para "retornar" a mudança
) {
    var mExpanded by remember { mutableStateOf(false) }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedItem.nome, // Usa o item recebido por parâmetro
            onValueChange = { }, // Não faz nada, pois a seleção é via dropdown
            readOnly = true, // Impede que o usuário digite no campo
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(ddmName) },
            trailingIcon = {
                Icon(
                    icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded }
                )
            }
        )

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item.nome) },
                    onClick = {
                        onItemSelected(item) // CHAMA A FUNÇÃO DE CALLBACK
                        mExpanded = false
                    }
                )
            }
        }
    }
}