package de.cashflow.domain

interface UseCase<in P> {

    interface Callback {

        fun onSuccess()

        fun onError(exception: Throwable)
    }

    fun execute(parameter: P, callback: Callback)
}