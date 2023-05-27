package com.example.fitnest.ui.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnest.R
import com.example.fitnest.ui.utils.poppinsBold
import com.example.fitnest.ui.utils.poppinsRegular

@Composable
fun FirstPage() {

    BoardingScreenContent(
        imageResource = R.drawable.first_boarding_img,
        title = "Track Your Goal",
        subTitle = "Don't worry if you have trouble determining your goals," +
                " We can help you determine your goals and track your goals"
    )
}

@Composable
fun BoardingScreenContent(
    imageResource: Int,
    title: String,
    subTitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            imageVector = ImageVector.vectorResource(imageResource),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp),
            text = title,
            style = TextStyle(
                fontFamily = poppinsBold,
                fontSize = 24.sp
            ),
            color = colorResource(R.color.boarding_title_color)
        )

        Text(
            modifier = Modifier
                .padding(start = 20.dp, top = 40.dp),
            text = subTitle,
            style = TextStyle(
                fontFamily = poppinsRegular,
                fontSize = 14.sp
            ),
            color = colorResource(R.color.gray_1)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFirstPage() {
    BoardingScreenContent(
        R.drawable.first_boarding_img,
        "Track Your Goal",
        "Don't worry if you have trouble determining your goals," +
                " We can help you determine your goals and track your goals"
    )
}