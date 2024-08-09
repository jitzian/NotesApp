package com.test.challenge.toyotaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.test.challenge.toyotaapp.ui.common.CustomAppBar
import com.test.challenge.toyotaapp.ui.main.ui.MainTasksState
import com.test.challenge.toyotaapp.ui.theme.ToyotaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToyotaAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { CustomAppBar() }
                ) {
                    MainTasksState(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(it)
                    )
                }
            }
        }
    }
}
