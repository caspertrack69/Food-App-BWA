package com.wiryadev.foodapp.ui.features.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.foodapp.R
import com.wiryadev.foodapp.data.model.Food
import com.wiryadev.foodapp.data.model.dummyFoods
import com.wiryadev.foodapp.ui.components.PrimaryButton
import com.wiryadev.foodapp.ui.theme.FoodAppTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
) {
    val food = dummyFoods[1]

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(
                vertical = 32.dp,
                horizontal = 24.dp,
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.gyoza_photo),
            contentDescription = stringResource(id = R.string.food_image),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(RoundedCornerShape(36.dp))
                .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(24.dp))
        DetailHeader(food = food)

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = food.description,
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colors.onSurface,
            ),
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.bundle),
            style = MaterialTheme.typography.subtitle1,
        )

        Spacer(modifier = Modifier.height(12.dp))
        Bundles(bundles = food.bundle)

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "\$${food.price}",
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = "/porsi",
                    style = MaterialTheme.typography.body2.copy(
                        color = MaterialTheme.colors.onBackground,
                    ),
                )
            }
            PrimaryButton(
                text = stringResource(id = R.string.order_now),
                onClick = { },
                modifier = Modifier.padding(start = 48.dp),
            )
        }
    }
}

@Composable
fun DetailHeader(
    food: Food,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = food.name,
                style = MaterialTheme.typography.h5.copy(
                    color = MaterialTheme.colors.onSurface,
                ),
            )
            Text(
                text = food.type,
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.onBackground,
                ),
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = food.rating.toString(),
                style = MaterialTheme.typography.subtitle2.copy(
                    color = MaterialTheme.colors.onSurface,
                ),
            )
            Image(
                painter = painterResource(id = R.drawable.star_1),
                contentDescription = stringResource(id = R.string.rating),
                modifier = Modifier.size(size = 24.dp)
            )
        }
    }
}

@Composable
fun Bundles(
    bundles: List<Int>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(bundles) { bundle ->
            Image(
                painter = painterResource(id = bundle),
                contentDescription = stringResource(id = R.string.food_image),
                modifier = Modifier.clip(RoundedCornerShape(24.dp)),
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    FoodAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.surface,
        ) {
            DetailScreen()
        }
    }
}