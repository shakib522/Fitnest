package com.example.fitnest.ui.onBoarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitnest.R
import com.example.fitnest.ui.Pager
import com.example.fitnest.ui.Screen
import com.example.fitnest.ui.pages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalPagerApi::class)
fun OnBoardingScreen(
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(0)
    Column(
        Modifier
            .verticalScroll(
                enabled = true,
                state = rememberScrollState()
            )
            .fillMaxSize()
    ) {

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(600.dp),
            state = pagerState,
            count = pages.size
        ) { pageIndex ->
            when (pages[pageIndex]) {
                Pager.First -> FirstPage()

                Pager.Second -> SecondPage()

                Pager.Third -> ThirdPage()

                Pager.Fourth -> FourthPage()

            }
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Box(
            modifier = Modifier
                .align(Alignment.End)
                .padding(10.dp)
        ) {

            val animatedProgress =
                animateFloatAsState(targetValue = (pagerState.currentPage + 1) / 4f)

            CircularProgressIndicator(
                color = colorResource(R.color.blue_linear_1),
                strokeWidth = 3.dp,
                progress = animatedProgress.value,
                modifier = Modifier
                    .requiredSize(65.dp)
            )

            IconButton(
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.blue_linear_1),
                                colorResource(R.color.blue_linear_2)
                            )
                        ),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .size(50.dp),
                onClick = {
                    coroutineScope.launch {
                        if (pagerState.currentPage < 3) {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage + 1
                            )
                        } else {
                            navController.navigate(
                                Screen.SignUp.route
                            )
                        }

                    }
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_right_arrow),
                    contentDescription = null,
                    tint = Color.White
                )
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnBoard() {
   // OnBoardingScreen()
}