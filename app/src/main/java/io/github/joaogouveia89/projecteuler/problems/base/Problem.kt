package io.github.joaogouveia89.projecteuler.problems.base

abstract class Problem<T>(
    val title: String,
    val projectEulerId: Int,
) where T : Any{
    val hasBeenCalculated: Boolean
        get() = _hasBeenCalculated

    val elapsedTime: Long
        get() = _elapsedTime


    private var _hasBeenCalculated = false

    private var _elapsedTime: Long = 0

    val result: Any
        get() = _result

    private var _result: Any = Any()

    protected abstract fun solutionImpl(): T

    fun solve(){
        val startTime = System.currentTimeMillis()
        _result = solutionImpl()
        _hasBeenCalculated = true
        val endTime = System.currentTimeMillis()
        _elapsedTime = endTime - startTime
    }
}
