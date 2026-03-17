package com.example.myapplication.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import com.example.myapplication.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    MaterialTheme {
        DashboardScreen()
    }
}

@Composable
fun DashboardScreen() {
    val quests = listOf("Study Kotlin", "Workout", "Drink Water")
    val achievements = listOf("First Quest", "3 Day Streak")

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.app_title))

        UserSectionCard(levelNo = 3, achievementLevel = "Adventurer", currentXP = 120, maxXP = 200)

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = stringResource(R.string.quests_title),
            rows = quests.map { InfoRowData(it, imageVector = Icons.Default.Star) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = stringResource(R.string.achievements_title),
            rows = achievements.map { InfoRowData(it, imageVector = Icons.Default.Face) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = stringResource(R.string.stats_title),
            rows = listOf(
                InfoRowData(stringResource(R.string.quests_completed), additionalInfo = "5"),
                InfoRowData(stringResource(R.string.total_xp), additionalInfo = "120"),
                InfoRowData(stringResource(R.string.achievements_title), additionalInfo = "3")
            )
        )
    }
}
data class InfoRowData(
    val title: String,
    val additionalInfo: String? = null,
    val imageVector: ImageVector? = null
)

@Composable
fun Title(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun UserSectionCard(
    levelNo: Int,
    achievementLevel: String,
    currentXP: Int,
    maxXP: Int,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Player Avatar",
                        modifier = Modifier.size(36.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "Level $levelNo $achievementLevel", style = MaterialTheme.typography.titleMedium)
                    Text(text = "XP: $currentXP / $maxXP", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = currentXP.toFloat() / maxXP.toFloat(),
                modifier = Modifier.fillMaxWidth().height(8.dp)
            )
        }
    }
}

@Composable
fun InfoRow(
    title: String,
    modifier: Modifier = Modifier,
    imageVector: ImageVector? = null,
    additionalInfo: String? = null
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (imageVector == null) Arrangement.SpaceBetween else Arrangement.Start
    ) {
        if (imageVector != null) {
            Icon(imageVector, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        if (additionalInfo != null) {
            if (imageVector != null) Spacer(modifier = Modifier.weight(1f))
            Text(text = additionalInfo, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun InfoSection(title: String, rows: List<InfoRowData>, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
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


/*@Composable
fun DashboardScreen() {
    val quests = listOf(
        "Study Kotlin",
        "Workout",
        "Drink Water"
    )
    val achievements = listOf(
        "First Quest",
        "3 Day Streak"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "LifeRPG",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Player Avatar",
                            modifier = Modifier.size(36.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = "Level 3 Adventurer",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "XP: 120 / 200",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LinearProgressIndicator(
                    progress = 120f / 200f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = "Today's Quests",
                    style = MaterialTheme.typography.titleMedium,

                )
                Spacer(modifier = Modifier.height(12.dp))
                quests.forEach { quest ->
                    Row(
                        modifier = Modifier.padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Quest Icon",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = quest,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Achievements",
                    style = MaterialTheme.typography.titleMedium,
                    )
                Spacer(modifier = Modifier.height(12.dp))
                achievements.forEach { achievement ->
                    Row(
                        modifier = Modifier.padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Default.Face,
                            contentDescription = "Achievement Icon",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = achievement,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Quick Stats",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Quests Completed",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "5",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total XP",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "120",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Achievements",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "3",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}*/

