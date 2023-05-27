package com.example.fitnest.ui.signUp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnest.R
import com.example.fitnest.ui.Screen
import com.example.fitnest.ui.utils.poppinsBold
import com.example.fitnest.ui.utils.poppinsRegular

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTextApi::class)
@Composable
fun SignUpScreen(navController:NavController) {
    Box(
        Modifier.background(Color.White)
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(Modifier.fillMaxSize()) {

            Text(
                text = "Hey there,", Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                fontSize = 16.sp,
                fontFamily = FontFamily(
                    Font(R.font.poppins_regular)
                )
            )

            Text(
                "Create an Account",
                Modifier
                    .padding(top = 5.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontSize = 20.sp,
                fontFamily = FontFamily(
                    Font(R.font.poppins_bold)
                )
            )

            SignUpEditText(
                Modifier
                    .padding(top = 30.dp),
                hint = "First Name",
                leadingIconResource = R.drawable.ic_profile
            )

            SignUpEditText(
                Modifier
                    .padding(top = 15.dp),
                "Last Name",
                R.drawable.ic_profile
            )

            SignUpEditText(
                Modifier
                    .padding(top = 15.dp),
                hint = "Email",
                leadingIconResource = R.drawable.ic_message
            )

            var text by remember { mutableStateOf("") }
            var showPassword by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_lock),
                        null
                    )
                },
                trailingIcon = {
                    if (showPassword) {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_show),
                                contentDescription = null
                            )
                        }
                    } else {
                        IconButton(onClick = { showPassword = true }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_hide),
                                contentDescription = null
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(14.dp),
                placeholder = { Text("Password", color = Color.Gray, fontFamily = poppinsRegular) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(R.color.sign_up_et_color),
                    textColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
            )

            Row(Modifier.padding(top = 10.dp)) {
                var checked by remember { mutableStateOf(false) }
                Checkbox(checked = checked, onCheckedChange = { checked = it })

                Text(
                    "By continuing you accept our Privacy Policy and Term of Use",
                    Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 5.dp),
                    style = TextStyle(
                        color = colorResource(R.color.sign_up_text_color)
                    )
                )
            }


            Text(
                textAlign = TextAlign.Center,
                text = "Register",
                style = TextStyle(color = Color.White, fontSize = 20.sp, fontFamily = poppinsBold),
                modifier = Modifier
                    .padding(top = 50.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = true, radius = 0.dp),
                        onClick = {
                            navController.navigate(Screen.Home.route)
                        }
                    )
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                colorResource(R.color.blue_linear_1),
                                colorResource(R.color.blue_linear_2)
                            )
                        ),
                        shape = RoundedCornerShape(30.dp)

                    )
                    .fillMaxWidth()
                    .height(60.dp)
                    .wrapContentHeight(),
            )

            Row(Modifier.padding(top = 25.dp).fillMaxWidth(1f)) {
                Divider(
                    color = colorResource(R.color.sign_up_horizontal_line),
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth(0.45f)
                        .align(Alignment.CenterVertically)
                )

                Text(
                    text = "  Or  "
                )

                Divider(
                    color = colorResource(R.color.sign_up_horizontal_line),
                    thickness = 1.dp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(50.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Unspecified
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = colorResource(R.color.sign_up_horizontal_line)
                    ),
                    onClick = { /* ... */ },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        1.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_google),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                    )
                }


                Button(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 30.dp)
                        .width(50.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Unspecified
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = colorResource(R.color.sign_up_horizontal_line)
                    ),
                    onClick = { /* ... */ },
                    // Uses ButtonDefaults.ContentPadding by default
                    contentPadding = PaddingValues(
                        1.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }

            }

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Already have an account? ")
                Text(
                    text = "Login", style = TextStyle(
                        fontFamily = poppinsRegular,
                        fontSize = 14.sp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                colorResource(R.color.purple_one),
                                colorResource(R.color.purple_two)
                            )
                        )
                    )
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpEditText(
    modifier: Modifier = Modifier,
    hint: String,
    leadingIconResource: Int,
    trailingIconResource: Int? = null
) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(leadingIconResource),
                null
            )
        },
        trailingIcon = {
            if (trailingIconResource != null) {
                Icon(
                    imageVector = ImageVector.vectorResource(trailingIconResource),
                    null
                )
            }
        },
        shape = RoundedCornerShape(14.dp),
        placeholder = { Text(hint, color = Color.Gray, fontFamily = poppinsRegular) },
        modifier = modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = colorResource(R.color.sign_up_et_color),
            textColor = colorResource(R.color.sign_up_text_color),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )

}
