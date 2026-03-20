package com.example.myapplication.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.presentation.theme.AliceBlue
import com.example.myapplication.presentation.theme.DeepTeal
import com.example.myapplication.presentation.theme.RosyTaupe
import com.example.myapplication.presentation.ui.components.Title

@Composable
fun HabitsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Title(
            title = stringResource(R.string.habits),
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium))
        )

        HabitItem(
            title = "Drink Water",
            streak = "5 days"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_large)))

        HabitItem(
            title = "Read 10 Pages",
            streak = "3 days"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

        HabitItem(
            title = "Sleep 8 Hours",
            streak = "7 days"
        )
    }
}

@Composable
fun HabitItem(
    title: String,
    streak: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small)))
            .background(AliceBlue)
            .padding(dimensionResource(R.dimen.padding_medium)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = title,
                tint = RosyTaupe,
                modifier = Modifier.size(dimensionResource(R.dimen.icon_size))
            )

            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = DeepTeal,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = streak,
            style = MaterialTheme.typography.bodyMedium,
            color = DeepTeal
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HabitsScreenPreview() {
    MaterialTheme {
        HabitsScreen()
    }
}
