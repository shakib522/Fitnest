package com.example.fitnest.ui.onBoarding

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitnest.R

@Composable
fun SecondPage() {
    BoardingScreenContent(
        imageResource = R.drawable.second_boarding_img,
        title = "Get Burn",
        subTitle = "Let’s keep burning, to achive yours goals, " +
                "it hurts only temporarily, if you give up now you will be in pain forever"
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondPage() {
    SecondPage()
}