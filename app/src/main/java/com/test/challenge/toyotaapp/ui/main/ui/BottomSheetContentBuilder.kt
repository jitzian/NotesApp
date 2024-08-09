package com.test.challenge.toyotaapp.ui.main.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.challenge.toyotaapp.R
import com.test.challenge.toyotaapp.ui.theme.ToyotaAppTheme

private const val TAG = "BottomSheetContentBuilder"
@Composable
fun BottomSheetContentBuilder(
    modifier: Modifier = Modifier,
    onSave: (String, String) -> Unit
) = Column(
    modifier = modifier
        .fillMaxWidth()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Text(
        text = stringResource(id = R.string.add_task_TEXT),
        style = MaterialTheme.typography.headlineMedium
    )
    OutlinedTextField(
        value = title,
        onValueChange = { title = it },
        label = { Text(stringResource(R.string.title_TEXT)) },
        modifier = Modifier.fillMaxWidth()
    )
    OutlinedTextField(
        value = content,
        onValueChange = { content = it },
        label = { Text(stringResource(R.string.content_TEXT)) },
        modifier = Modifier.fillMaxWidth()
    )
    Log.e(TAG, "BottomSheetContentBuilder: -> ${title.isNotBlank() && content.isNotBlank()}")
    CustomButton(
        modifier = Modifier.align(Alignment.End),
        onClick = { onSave(title, content) },
        label = stringResource(R.string.save_TEXT),
        isEnabled = title.isNotBlank() && content.isNotBlank()
    )
}

@Preview
@Composable
private fun PrevBottomSheetContentBuilder() = ToyotaAppTheme {
    BottomSheetContentBuilder(onSave = { _, _ -> })
}