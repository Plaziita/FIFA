package com.example.fifa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fifa.data.Jugador
import com.example.fifa.model.ListaJugadores.jugadores
import com.example.fifa.ui.theme.FIFATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIFATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FIFApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FIFApp(){
    Scaffold(
        topBar = {
            FIFATopBar()
        }
    ) {
            it ->
        LazyColumn(contentPadding = it) {
            items(jugadores) {
                FIFACard(
                    jugador = it,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun FIFACard(jugador: Jugador, modifier: Modifier) {
    var rotated by remember { mutableStateOf(false) }
    val rotar by animateFloatAsState(
        targetValue = if(rotated) 180f else 0f,
        animationSpec = tween(600)
    )
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(16.dp)
            .graphicsLayer {
                rotationY = rotar
                cameraDistance = 8 * density
            }
            .clickable { rotated = !rotated }
    ) {

        if (!rotated){
            CartaDelante(jugador)
        }else{
            CartaDetras(jugador,rotar)
        }
    }
}

@Composable
fun CartaDetras(jugador: Jugador, rotar: Float) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.cartadelante),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .size(600.dp)
        )
    }
}

@Composable
fun CartaDelante(jugador: Jugador) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.cartadelante),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .size(600.dp)
        )
        Image(
            painter = painterResource(id = jugador.foto),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .padding(top = 23.dp)
                .align(Alignment.TopCenter)

        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .align(Alignment.Start)
            ){
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = stringResource(id = jugador.puntuacion),
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = stringResource(id = jugador.posicion),
                    color = Color.Black,
                    style = MaterialTheme.typography.displayMedium
                )
                Image(
                    painter = painterResource(id = jugador.bandera),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                )
                Image(
                    painter = painterResource(id = jugador.escudo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            Text(
                text = stringResource(jugador.nombre),
                color = Color.Black,
                style = MaterialTheme.typography.displayMedium
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ){
                Row {
                    Text(
                        text = stringResource(jugador.ritmo),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 35.dp)
                    )
                    Text(
                        text = stringResource(jugador.regate),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                    )
                }
                Row {
                    Text(
                        text = stringResource(jugador.tiro),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 35.dp)

                    )
                    Text(
                        text = stringResource(jugador.defensa),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                    )
                }
                Row {
                    Text(
                        text = stringResource(jugador.pase),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 35.dp)

                    )
                    Text(
                        text = stringResource(jugador.fisico),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                    )
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FIFATopBar(){
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    )
}

@Preview
@Composable
fun FIFAPreview(){
    FIFATheme {
        FIFApp()
    }
}

@Preview
@Composable
fun FIFADarkThemePreview() {
    FIFATheme(darkTheme = true) {
        FIFApp()
    }
}
