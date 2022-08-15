package com.wiryadev.foodapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.foodapp.R
import com.wiryadev.foodapp.data.model.Food
import com.wiryadev.foodapp.data.model.dummyFoods
import com.wiryadev.foodapp.ui.theme.FoodAppTheme

@Composable
fun FoodItem(
    food: Food,
    onFoodClick: (Food) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .clickable(
                onClick = { onFoodClick(food) }
            )
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 8.dp,
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = food.image),
                contentDescription = stringResource(id = R.string.food_image),
                modifier = Modifier.clip(RoundedCornerShape(24.dp)),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = food.name,
                    style = MaterialTheme.typography.subtitle2,
                )
                Text(
                    text = food.type,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = food.rating.toString(),
                style = MaterialTheme.typography.subtitle2,
            )
            Image(
                painter = painterResource(id = R.drawable.star_1),
                contentDescription = stringResource(id = R.string.rating),
                modifier = Modifier.size(size = 24.dp)
            )
        }
    }
}

@Preview
@Composable
fun FoodItemPreview() {
    FoodAppTheme {
        FoodItem(food = dummyFoods[1], onFoodClick = {})
    }
}