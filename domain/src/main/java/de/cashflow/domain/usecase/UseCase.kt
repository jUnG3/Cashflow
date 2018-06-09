package de.cashflow.domain.usecase

interface UseCase<in P> {

    interface Callback {

        fun onSuccess()

        fun onError(exception: Throwable)
    }

    fun execute(parameter: P, callback: Callback)
}