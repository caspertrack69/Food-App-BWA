package com.wiryadev.foodapp.ui.features.get_started

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.foodapp.R
import com.wiryadev.foodapp.ui.components.PrimaryButton
import com.wiryadev.foodapp.ui.theme.FoodAppTheme
import com.wiryadev.foodapp.ui.theme.Gray400

@Composable
fun GetStartedScreen(
    onExploreClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(
                vertical = 64.dp,
                horizontal = 24.dp,
            )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.onboarding_illustration
            ),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp),
        )
        Text(
            text = stringResource(id = R.string.onboarding_caption),
            style = MaterialTheme.typography.body1.copy(color = Gray400),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(id = R.string.onboarding_title),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        PrimaryButton(
            text = stringResource(id = R.string.explore_now),
            onClick = onExploreClick,
        )
    }
}

@Preview
@Composable
fun GetStartedPreview() {
    FoodAppTheme {
        GetStartedScreen(
            onExploreClick = {}
        )
    }
}