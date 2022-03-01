package io.github.joaogouveia89.projecteuler.problems.solutions

import io.github.joaogouveia89.projecteuler.problems.base.Problem
import io.github.joaogouveia89.projecteuler.problems.sequences.FibonacciGenerator
import java.math.BigInteger

object EvenFibonacciNumbers: Problem<Int>(
    title = "Even Fibonacci numbers",
    projectEulerId = 2
) {
    private val fibonacciGenerator = FibonacciGenerator(BigInteger("4000000"))
    override fun solutionImpl(): Int {
        fibonacciGenerator.generateSequence()
        return fibonacciGenerator.sequenceSum {
            it.mod(BigInteger("2")) == BigInteger.ZERO
        }.toInt()
    }
}