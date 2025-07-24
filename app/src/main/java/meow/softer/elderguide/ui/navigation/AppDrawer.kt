package meow.softer.elderguide.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meow.softer.elderguide.R

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    currentRoute: String,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(24.dp))
        AppLogo(Modifier.padding(16.dp))
        Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = .2f))
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelected = currentRoute == AppDestination.HOME,
            action = {
                closeDrawer()
            }
        )

        DrawerButton(
            icon = Icons.Filled.Settings,
            label = "setting",
            isSelected = currentRoute == AppDestination.SETTING,
            action = {
                closeDrawer()
            }
        )
    }
}

@Preview
@Composable
private fun AppDrawerPreview() {
    AppDrawer(
        currentRoute = AppDestination.HOME,
    ) { }
}

@Composable
private fun AppLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(R.drawable.elderlogo),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text("Elder Guide", fontSize = 26.sp)
    }
}

@Composable
private fun DrawerButton(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colorScheme
    val imageAlpha = if (isSelected) {
        1f
    } else {
        0.6f
    }
    val textIconColor = if (isSelected) {
        colors.primary
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        colors.primary.copy(alpha = 0.12f)
    } else {
        Color.Transparent
    }

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()
    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(
            onClick = action,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(textIconColor),
                    alpha = imageAlpha
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = textIconColor
                )
            }
        }
    }
}
