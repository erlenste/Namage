package no.erlenste.namage.ui.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import no.erlenste.namage.R
import no.erlenste.namage.ui.theme.NamageTheme
import no.erlenste.namage.ui.view.components.AppToolbar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NamageTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppToolbar(getString(R.string.app_name)) }
                ) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        InputComponent()

        //TODO: Show result when it is present in state
    }
}

@Composable
fun InputComponent(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // TODO: handle state for TextField
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Skriv inn et navn") },
        )

        //TODO: Send event to viewmodel with name when button is clicked
        Button(
            modifier = Modifier.padding(4.dp),
            onClick = {}
        ) {
            Text(text = "Sjekk alder", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun NamageCard(modifier: Modifier = Modifier, name: String) {
    Card(modifier = modifier.padding(8.dp)) {
        Text(
            modifier = modifier.padding(8.dp),
            text = name,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputComponentPreview() {
    NamageTheme {
        InputComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun NamageCardPreview() {
    NamageTheme {
        NamageCard(name = "Denne personen er 60 år")
    }
}