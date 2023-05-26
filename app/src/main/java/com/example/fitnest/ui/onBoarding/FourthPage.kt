package com.example.fitnest.ui.onBoarding

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitnest.R
import com.example.fitnest.ui.Pager

@Composable
fun FourthPage(){
    BoardingScreenContent(
        imageResource = R.drawable.fourth_boarding_img,
        title = "Improve Sleep  Quality",
        subTitle = "Improve the quality of your sleep with us," +
                " good quality sleep can bring a good mood in the morning"
    )
}

@Preview
@Composable
fun PreviewFourthPage(){
    FourthPage()
}