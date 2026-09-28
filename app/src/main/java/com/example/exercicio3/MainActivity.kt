package com.example.exercicio3

import android.R.attr.name
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicio3.ui.theme.Exercicio3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercicio3Theme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    InformarIdade(
                        modifier = Modifier
                            .padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun InformarIdade(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){

        var idade by remember {
            mutableStateOf(0)
        }

        var statusIdade by remember { mutableStateOf("MENOR") }

        Text(
            text = "Qual é sua idade?",
            fontSize = 30.sp,
            color = Color(0xFF4958AF),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 14.sp,
            color = Color(0xFF2D2C33),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "$idade",
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(
                modifier = Modifier.size(60.dp),
                onClick = {
                    if (idade <= 0){
                        idade = 0
                    }else{
                        idade-=1
                    }
                },
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    painterResource(R.drawable.outline_check_indeterminate_small_24),
                    contentDescription = "Botão menos"
                )
            }
            Button(
                modifier = Modifier
                    .size(60.dp),
                onClick = {
                    if (idade >= 180){
                        idade = 180
                    }else{
                        idade+=1
                    }
                }, shape = RoundedCornerShape(12.dp),
            ) {
                Icon(
                    painterResource(R.drawable.baseline_add_24),
                    contentDescription = "Botão mais"
                )
            }
        }
            Text(
                text = "Você é $statusIdade de idade",
                fontSize = 20.sp,
                color = Color(0xFF4958AF)
            )
        if (idade >= 18 ){
            statusIdade = "MAIOR"
        }else{
            statusIdade = "MENOR"
        }

    }

}

@Composable
fun InformarIdade(modifier: Modifier = Modifier) {
    Exercicio3Theme {
        InformarIdade("Android")
    }
}