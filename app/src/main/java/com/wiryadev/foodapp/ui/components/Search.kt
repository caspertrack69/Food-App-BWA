package com.wiryadev.foodapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.foodapp.R
import com.wiryadev.foodapp.ui.theme.FoodAppTheme

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        maxLines = 1,
        shape = RoundedCornerShape(50.dp),
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSecondary,
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_hint),
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.onSecondary,
                ),
            )
        },
        modifier = modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
fun SearchPreview() {
    val test = remember {
        mutableStateOf("")
    }
    FoodAppTheme {
        SearchBar(
            query = test.value,
            onQueryChange = {
                test.value = it
            }
        )
    }
}