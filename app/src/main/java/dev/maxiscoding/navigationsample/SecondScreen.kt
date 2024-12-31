package dev.maxiscoding.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.maxiscoding.navigationsample.ui.theme.NavigationSampleTheme

@Composable
fun SecondScreen(name: String, onNavigateToFirstScreen: () -> Unit, onNavigateToThirdScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Second Screen")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Welcome, $name!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigateToFirstScreen() }) {
            Text(text = "Go to the First Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigateToThirdScreen() }) {
            Text(text = "Go to the Third Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    NavigationSampleTheme {
        SecondScreen("test", {}, {})
    }
}