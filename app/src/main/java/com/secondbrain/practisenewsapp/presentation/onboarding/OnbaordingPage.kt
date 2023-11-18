package com.secondbrain.practisenewsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.secondbrain.practisenewsapp.R

data class OnboardingPage(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Stay Informed",
        description = "Explore a diverse range of news topics and stay up-to-date with the latest events and stories from around the world. Our comprehensive coverage ensures you never miss out on what's happening.",
        image = R.drawable.onboarding_page_1
    ),
    OnboardingPage(
        title = "Personalized Feeds",
        description = "Tailor your news feed to match your interests. Whether you're into politics, technology, sports, or entertainment, our app lets you curate a personalized news experience that matters to you.",
        image = R.drawable.onboarding_page_2
    ),
    OnboardingPage(
        title = "Breaking News Alerts",
        description = "Receive timely notifications for breaking news and critical updates. Stay ahead of the curve with instant alerts on significant events, ensuring you're always informed and prepared.",
        image = R.drawable.onboarding_page_3
    ),
    // Add more pages as needed
)
