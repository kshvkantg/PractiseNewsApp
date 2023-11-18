package com.secondbrain.practisenewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.secondbrain.practisenewsapp.presentation.onboarding.OnBoardingScreen
import com.secondbrain.practisenewsapp.ui.theme.PractiseNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        //calling splash screen before setting the main activity content

        setContent {
            PractiseNewsAppTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                ){
                    OnBoardingScreen()
                }
            }
        }
    }
}