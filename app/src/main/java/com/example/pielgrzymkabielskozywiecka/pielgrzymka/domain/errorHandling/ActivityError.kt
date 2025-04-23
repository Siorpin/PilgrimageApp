package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling

sealed interface ActivityError : Error {
    enum class Execution : ActivityError {
        ACTIVITY_NOT_FOUND,
        UNKNOWN
    }
}