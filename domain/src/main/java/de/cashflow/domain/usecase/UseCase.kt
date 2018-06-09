package de.cashflow.domain.usecase

interface UseCase<in P, R> {

    interface Callback<in R> {

        fun onSuccess(output: R)

        fun onError(exception: Throwable)
    }

    fun execute(input: P, callback: Callback<R>)
}