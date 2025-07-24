package meow.softer.elderguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import meow.softer.elderguide.ui.App
import meow.softer.elderguide.ui.theme.ElderGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ElderGuideTheme {
                App()
            }
        }
    }
}