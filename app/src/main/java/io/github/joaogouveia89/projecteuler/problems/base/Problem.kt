package io.github.joaogouveia89.projecteuler.problems.base

abstract class Problem<T>(
    val title: String,
    val projectEulerId: Int,
){
    val hasBeenCalculated: Boolean
        get() = _hasBeenCalculated

    val elapsedTime: Long
        get() = _elapsedTime


    protected var _hasBeenCalculated = false

    protected var _elapsedTime: Long = 0

    val result: T
        get() = _result

    protected abstract var _result: T

    protected abstract fun solutionImpl()

    fun solve(){
        val startTime = System.currentTimeMillis()
        solutionImpl()
        val endTime = System.currentTimeMillis()
        _elapsedTime = endTime - startTime
    }
}
