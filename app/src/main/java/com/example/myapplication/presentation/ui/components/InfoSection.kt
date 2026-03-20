package com.example.myapplication.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.theme.AliceBlue
import com.example.myapplication.presentation.theme.DeepTeal
import com.example.myapplication.presentation.ui.util.InfoRowData
import kotlin.collections.forEach

@Composable
fun InfoSection(title: String, rows: List<InfoRowData>, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth(),colors = CardDefaults.cardColors(containerColor = DeepTeal)) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            Text(text = title, style = MaterialTheme.typography.titleMedium,color=AliceBlue)
            Spacer(modifier = Modifier.height(12.dp))
            rows.forEach { row ->
                InfoRow(
                    title = row.title,
                    imageVector = row.imageVector,
                    additionalInfo = row.additionalInfo
                )
            }
        }
    }
}
