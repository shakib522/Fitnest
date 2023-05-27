package com.example.fitnest.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnest.R
import com.example.fitnest.ui.Screen
import com.example.fitnest.ui.utils.poppinsBold


@Composable
fun IntroScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.blue_linear_1),
                        colorResource(R.color.blue_linear_2)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(R.drawable.ic_fitnestx),
                contentDescription = null
            )

            Text(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                text = "Everybody Can Train",
                style = TextStyle(color = colorResource(R.color.gray_1), fontSize = 18.sp)
            )

        }

        Button(
            modifier = Modifier
                .padding(start = 15.dp, bottom = 25.dp, end = 15.dp)
                .height(60.dp)
                .align(Alignment.BottomEnd)
                .fillMaxWidth()

            ,
            colors =ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            onClick = {
                navController.navigate(Screen.OnBoarding.route){
                }
            }
        ){
            Text(
                text = "Get Started",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = poppinsBold,
                    color = colorResource(R.color.blue_linear_2)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowIntroScreen() {
   // IntroScreen()
}