package io.github.droidkaigi.feeder.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckBox
import androidx.compose.material.icons.rounded.CheckBoxOutlineBlank
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.droidkaigi.feeder.Filters
import io.github.droidkaigi.feeder.core.theme.ConferenceAppFeederTheme

enum class FilterState(val text: String) {
    Favorite("Favorites")
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
        Input(
            text = FilterState.Favorite.text,
            isChecked = filterState.filterFavorite,
            onClick = {
                onFavoriteFilterChanged(!filterState.filterFavorite)
            }
        )
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
            .padding(all = 12.dp)
    ) {
        Icon(
            imageVector = if (isChecked) {
                Icons.Rounded.CheckBox
            } else {
                Icons.Rounded.CheckBoxOutlineBlank
            },
            contentDescription = "filter $text"
        )
        Spacer(Modifier.width(8.dp))
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = text,
            style = MaterialTheme.typography.body1
        )
        Spacer(Modifier.width(8.dp))
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
