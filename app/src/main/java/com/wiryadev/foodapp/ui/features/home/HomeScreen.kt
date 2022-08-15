package com.wiryadev.foodapp.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wiryadev.foodapp.R
import com.wiryadev.foodapp.ui.components.Categories
import com.wiryadev.foodapp.ui.components.FoodItem
import com.wiryadev.foodapp.ui.components.SearchBar
import com.wiryadev.foodapp.ui.theme.FoodAppTheme

@ExperimentalMaterialApi
@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(),
    onFoodClick: (Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(
        uiState = uiState,
        onQueryChange = viewModel::onQueryChanged,
        onFoodClick = onFoodClick,
    )
}

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onFoodClick: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            HomeHeader(
                modifier = Modifier.padding(top = 32.dp)
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.home_question),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
            )
        }

        item {
            SearchBar(
                query = uiState.searchQuery,
                onQueryChange = onQueryChange,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 24.dp),
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.categories),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(
                        top = 24.dp,
                        start = 24.dp,
                    ),
            )
        }

        item {
            Categories(
                categories = uiState.categories,
                modifier = Modifier.padding(top = 12.dp),
                onCategoryClick = {},
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.most_ordered),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .padding(
                        top = 24.dp,
                        start = 24.dp,
                        bottom = 12.dp,
                    ),
            )
        }

        items(uiState.foods) { food ->
            FoodItem(
                food = food,
                onFoodClick = {
                    onFoodClick(food.image)
                },
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_photo),
            contentDescription = stringResource(id = R.string.profile_picture),
            modifier = Modifier.clip(CircleShape),
        )
        Column(
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = stringResource(id = R.string.home_greeting),
                style = MaterialTheme.typography.body2.copy(
                    MaterialTheme.colors.onBackground,
                ),
            )
            Text(
                text = "Luna Polar",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview
@Composable
fun HomeHeaderPreview() {
    FoodAppTheme {
        HomeHeader()
    }
}