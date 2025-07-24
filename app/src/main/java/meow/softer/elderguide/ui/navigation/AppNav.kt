package meow.softer.elderguide.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import meow.softer.elderguide.ui.home.HomeScreen

object AppDestination {
    const val HOME = "home"
    const val CAMERA = "camera"
    const val GUIDE = "guide"
    const val SETTING = "setting"
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestination.HOME,
    openDrawer: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestination.HOME) {
            HomeScreen(
                openDrawer = {openDrawer()}
            )
        }
    }
}