package meow.softer.elderguide.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import meow.softer.elderguide.ui.navigation.AppDestination
import meow.softer.elderguide.ui.navigation.AppDrawer
import meow.softer.elderguide.ui.navigation.AppNavGraph
import meow.softer.elderguide.ui.theme.ElderGuideTheme

@Composable
fun App() {
    ElderGuideTheme {
        val navController = rememberNavController()
        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: AppDestination.HOME

        val drawerState = rememberDrawerState(DrawerValue.Closed)
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(300.dp),
                    windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    AppDrawer(
                        currentRoute = currentRoute,
                        closeDrawer = { coroutineScope.launch { drawerState.close() } }
                    )
                }
            },
            content = {
                    AppNavGraph(
                        openDrawer ={coroutineScope.launch { drawerState.open() }}
                    )
            }
        )

    }
}