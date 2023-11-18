package com.secondbrain.practisenewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import com.secondbrain.practisenewsapp.onBarding.ui.OnBoardingScreen
import com.secondbrain.practisenewsapp.core.theme.PractiseNewsAppTheme
import com.secondbrain.practisenewsapp.onBarding.presentation.OnBoardingViewModel
import com.secondbrain.practisenewsapp.onBarding.presentation.usecase.AppEntryUseCases
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var appEntryUseCases: AppEntryUseCases
    private val viewModel by viewModels<OnBoardingViewModel>()

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
                    OnBoardingScreen(viewModel::onEvent)
                }
            }
        }
    }
}