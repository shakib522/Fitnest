package com.example.fitnest.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.fitnest.R
import com.example.fitnest.ui.ui.theme.black_color
import com.example.fitnest.ui.ui.theme.grey2
import com.example.fitnest.ui.utils.poppinsBold
import com.example.fitnest.ui.utils.poppinsRegular

@Composable
fun HomeScreen(navController: NavHostController?) {
    Box(
        Modifier.background(Color.White)
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Welcome Back,",
                        color = grey2,
                        fontFamily = poppinsRegular,
                        fontSize = 12.sp
                    )

                    Text(
                        text = "Shakib Hasan",
                        color = black_color,
                        fontFamily = poppinsBold,
                        fontSize = 20.sp
                    )


                }
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_notification),
                        contentDescription = null
                    )
                }
            }


        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen(null)
}