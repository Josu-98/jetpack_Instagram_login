package com.josu98.jetpack_instagram_login

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 18.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailField(email) { email = it }
        Spacer(modifier = Modifier.size(8.dp))
        PasswordField(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnabled)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(16.dp))
        SocialLogin()

    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Facebook logo", modifier = Modifier.size(24.dp))
        Text(
            text = "Continue as Josue",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        HorizontalDivider(
            modifier = Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnabled: Boolean) {
    Button(onClick = { /*TODO*/ }, enabled = loginEnabled, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Login")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun PasswordField(password: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmailField(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        label = { Text(text = "Email") },
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.insta),
        contentDescription = "Instagram Logo",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close button",
        modifier = modifier.clickable { activity.finish() })
}
