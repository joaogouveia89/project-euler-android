package io.github.joaogouveia89.projecteuler.problems.solutions

import io.github.joaogouveia89.projecteuler.problems.base.Problem
import io.github.joaogouveia89.projecteuler.problems.sequences.PrimesGenerator
import java.math.BigInteger
import kotlin.math.sqrt

object LargestPrimeFactor: Problem<Int>(
    title = "Largest Prime Factor",
    projectEulerId = 3
) {
    private val primesGenerator = PrimesGenerator(BigInteger(sqrt(600851475143.0).toInt().toString()))

    override fun solutionImpl(): Int {
        primesGenerator.generateSequence()
        return 0
    }
}