package com.test.challenge.toyotaapp.ui.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.challenge.toyotaapp.data.domain.model.TaskDTO
import com.test.challenge.toyotaapp.ui.theme.ToyotaAppTheme

@Composable
fun TaskRowItem(
    modifier: Modifier = Modifier,
    data: TaskDTO,
) = Card(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = data.title,
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = data.content,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}


@Preview
@Composable
private fun PrevTaskRowItem() = ToyotaAppTheme {
    TaskRowItem(data = TaskDTO(id = -1, title = "Task 1", content = "Description 1"))
}