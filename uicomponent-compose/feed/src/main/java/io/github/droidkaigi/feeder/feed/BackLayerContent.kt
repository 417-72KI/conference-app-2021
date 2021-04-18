package io.github.droidkaigi.feeder.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.droidkaigi.feeder.Filters
import io.github.droidkaigi.feeder.core.theme.ConferenceAppFeederTheme

enum class FilterState(val text: String) {
    All("All"), Favorite("Favorites")
}

@Composable
fun BackLayerContent(
    filterState: Filters,
    onFavoriteFilterChanged: (filtered: Boolean) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp)
    ) {
        FilterState.values().forEach { filter ->
            val isChecked = when (filter) {
                FilterState.All -> !filterState.filterFavorite
                FilterState.Favorite -> filterState.filterFavorite
            }
            Input(
                text = filter.text,
                isChecked = isChecked,
                onClick = {
                    onFavoriteFilterChanged(filter == FilterState.Favorite)
                }
            )
        }
    }
}

@Composable
private fun Input(
    text: String,
    isChecked: Boolean = false,
    onClick: () -> Unit,
) {
    Row(
        Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .background(
                if (isChecked) {
                    ConferenceAppFeederTheme.filterMuskColor
                } else {
                    Color.Transparent
                }
            )
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = text,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBackLayerContent() {
    ConferenceAppFeederTheme {
        Surface(color = MaterialTheme.colors.primary) {
            BackLayerContent(
                filterState = Filters(),
                onFavoriteFilterChanged = { }
            )
        }
    }
}
