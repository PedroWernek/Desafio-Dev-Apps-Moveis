package br.edu.up.desafio.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.desafio.domain.User
import br.edu.up.desafio.presentation.boas_vindas.BoasVindasScreen
import br.edu.up.desafio.presentation.login.LoginScreen
import br.edu.up.desafio.presentation.settings.ConfiguracoesScreen


@Composable
fun AppNavigation(user: User){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tela1") {
        composable("login") { LoginScreen(navController, user) }
        composable("boas_vindas") { BoasVindasScreen(navController, user) }
        composable("configuracoes") { ConfiguracoesScreen(navController, user) }
    }
}