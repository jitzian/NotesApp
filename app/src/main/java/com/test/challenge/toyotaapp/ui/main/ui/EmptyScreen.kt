package com.test.challenge.toyotaapp.ui.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.challenge.toyotaapp.R
import com.test.challenge.toyotaapp.ui.theme.ToyotaAppTheme

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(all = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
) {
    Image(
        painter = painterResource(id = R.drawable.empty_result),
        contentDescription = null,
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
    )
    Text(
        text = "No data available",
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 16.dp),
        style = MaterialTheme.typography.displaySmall
    )
}

@Preview
@Composable
private fun PrevEmptyScreen() = ToyotaAppTheme {
    EmptyScreen()
}