package com.example.fitnest.ui.onBoarding

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitnest.R
import com.example.fitnest.ui.Pager

@Composable
fun ThirdPage() {
    BoardingScreenContent(
        imageResource = R.drawable.third_baording_img,
        title = "Eat Well",
        subTitle = "Let's start a healthy lifestyle with us," +
                " we can determine your diet every day. healthy eating is fun"
    )
}

@Preview
@Composable
fun PreviewThirdPage() {
    ThirdPage()
}