package io.github.joaogouveia89.projecteuler.problems.base

abstract class Problem<T>(
    val title: String,
    val projectEulerId: Int,
){
    val hasBeenCalculated: Boolean
        get() = _hasBeenCalculated

    protected var _hasBeenCalculated = false

    val result: T
        get() = _result

    protected abstract var _result: T

    abstract fun solve()
}
