package meow.softer.elderguide.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import meow.softer.elderguide.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    openDrawer: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            InsetAwareTopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = {
                        Log.d("Mytest", "icon clicked")
                        coroutineScope.launch { openDrawer() }
                    }) {
                        Image(
                            painter = painterResource(R.drawable.elderlogo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        HomeScreenContent(modifier)
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(50.dp))
        SearchIcon()
        Text("Click to search")
    }
}

@Composable
fun SearchIcon(modifier: Modifier = Modifier, size: Dp = 250.dp) {
    Box(
        modifier = modifier
            .border(3.dp, color = Color.Gray, RoundedCornerShape(5.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.camera), contentDescription = null,
            modifier = Modifier.size(size)
        )
    }
}