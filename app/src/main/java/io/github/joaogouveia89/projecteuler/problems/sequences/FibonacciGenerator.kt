package io.github.joaogouveia89.projecteuler.problems.sequences

import io.github.joaogouveia89.projecteuler.problems.base.MathSequence
import java.math.BigInteger

class FibonacciGenerator(private val roof: BigInteger): MathSequence(roof) {
    override var sequenceWork = Thread{
        addAll(listOf(
            BigInteger.ONE,
            BigInteger("2")
        ))
        var aux: BigInteger
        var current = get(sequenceSize() - 1)
        var last = get(sequenceSize() - 2)

        while (roof > current) {
            aux = current
            current += last
            last = aux
            add(current)
        }
    }

    override fun generateSequence() = sequenceWork.start()
}