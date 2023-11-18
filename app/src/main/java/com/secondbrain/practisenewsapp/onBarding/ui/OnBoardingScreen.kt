package com.secondbrain.practisenewsapp.onBarding.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.secondbrain.practisenewsapp.R
import com.secondbrain.practisenewsapp.core.utils.Dimens
import com.secondbrain.practisenewsapp.core.components.FillButton
import com.secondbrain.practisenewsapp.onBarding.data.onboardingPages
import com.secondbrain.practisenewsapp.core.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0)

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf(R.string.empty_string, R.string.next)
                    1 -> listOf(R.string.back, R.string.next)
                    2 -> listOf(R.string.back, R.string.get_started)
                    else -> listOf()
                }
            }
        }

        // Upper part of the screen is view Pager that load versions of Onboarding page
        //horizontally lower part after spaces is kind of a navigation bar

        HorizontalPager(pageCount = onboardingPages.size, state = pagerState) {
            OnboardingPageView(modifier = Modifier, page = onboardingPages[it])
        }

        Spacer(modifier = Modifier.weight(1f))

        // navigation bar
        Row(
            modifier = Modifier
                .padding(horizontal = Dimens.mediumPadding2)
                .navigationBarsPadding()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            PageIndicator(
                modifier = Modifier.width(52.dp),
                pageSize = onboardingPages.size,
                selectedPage = pagerState.currentPage
            )

            ButtonPallet(
                modifier = Modifier.padding(vertical = 10.dp),
                pagerState = pagerState, buttonState = buttonState
            )

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ButtonPallet(
    modifier: Modifier,
    pagerState: PagerState,
    buttonState: State<List<Int>>
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        val scope = rememberCoroutineScope()

        if (pagerState.currentPage != 0) {
            // don't initiate back button in case it's the first page
            FillButton(
                text = stringResource(buttonState.value[0]),
                isPrimary = false
            ) {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            }
        }

        FillButton(
            text = stringResource(buttonState.value[1]),
            isPrimary = true
        ) {
            scope.launch {
                if (pagerState.currentPage != onboardingPages.size) {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                } else {
                    // in the case of last possible state the forward button would initiate home page
                }
            }
        }
    }
}

private const val TAG: String = "OnBoardingScreen"
