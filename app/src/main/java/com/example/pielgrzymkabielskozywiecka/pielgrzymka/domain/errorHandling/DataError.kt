package com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling

sealed interface DataError: Error {
    enum class Network : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_CONNECTION,
        SERVER_ERROR,
        UNKNOWN_HOST,
        UNKNOWN
    }

    enum class Local: DataError {
        DISK_FULL
    }
}
