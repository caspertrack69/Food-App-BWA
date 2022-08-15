package com.wiryadev.foodapp.ui.features.home

import androidx.lifecycle.ViewModel
import com.wiryadev.foodapp.data.model.Category
import com.wiryadev.foodapp.data.model.dummyCategories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> get() = _uiState.asStateFlow()

    fun onQueryChanged(query: String) {
        _uiState.update {
            it.copy(searchQuery = query)
        }
    }
}

data class HomeUiState(
    val searchQuery: String = "",
    val categories: List<Category> = dummyCategories,
)