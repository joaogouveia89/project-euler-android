package io.github.joaogouveia89.projecteuler.problems.solutions

import io.github.joaogouveia89.projecteuler.problems.base.Problem

object MultiplesOf3AndFive: Problem<Int>(
    title = "Multiples of 3 and 5",
    projectEulerId = 1
) {

    override var _result: Int = 0

    override fun solve()  {
        var sum = 0
        for (i in 3..1000) {
            if (i % 3 == 0 || i % 5 == 0) sum += i
        }
        _result = sum
        _hasBeenCalculated = true
    }
}