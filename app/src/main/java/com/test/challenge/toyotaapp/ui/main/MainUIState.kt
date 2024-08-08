package com.test.challenge.toyotaapp.ui.main

import com.test.challenge.toyotaapp.data.domain.model.TaskDTO

sealed interface MainUIState {

    data object Empty : MainUIState
    data object Loading : MainUIState
    data class Success(val data: List<TaskDTO>) : MainUIState
    data class Error(val message: String) : MainUIState

}