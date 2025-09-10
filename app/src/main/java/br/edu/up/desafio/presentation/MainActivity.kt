package br.edu.up.desafio.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.edu.up.desafio.domain.User
import br.edu.up.desafio.presentation.components.AppNavigation
import br.edu.up.desafio.ui.theme.DesafioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesafioTheme {
                val usuario: User = User("")
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.Companion.padding(innerPadding)) {
                        AppNavigation(usuario)
                    }
                }
            }
        }
    }
}