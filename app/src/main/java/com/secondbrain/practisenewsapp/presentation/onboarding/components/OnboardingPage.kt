package com.secondbrain.practisenewsapp.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.secondbrain.practisenewsapp.R
import com.secondbrain.practisenewsapp.presentation.Dimens
import com.secondbrain.practisenewsapp.presentation.onboarding.OnboardingPage
import com.secondbrain.practisenewsapp.presentation.onboarding.onboardingPages
import com.secondbrain.practisenewsapp.ui.theme.PractiseNewsAppTheme

@Composable
fun OnboardingPageView(
    modifier: Modifier,
    page : OnboardingPage
) {
    Column (
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.6f),
            painter = painterResource(id = page.image),
            contentDescription = page.title,
            contentScale = ContentScale.Crop // Setting image dimensions or
            // crop ration for different kind of screen resolutions
        )
        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))

        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(Dp.Hairline))

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.mediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = false)
@Composable
fun OnBoardingPageReview(){
    PractiseNewsAppTheme {
        OnboardingPageView(
            modifier = Modifier,
            page = onboardingPages[0]
        )
    }
}
