package io.github.joaogouveia89.projecteuler.sdkxt

import java.math.BigInteger

class BigIntegerRangeIterator(
    private val range: ClosedRange<BigInteger>
) : Iterator<BigInteger> {
    private var current = range.start

    override fun hasNext(): Boolean =
        current <= range.endInclusive

    override fun next(): BigInteger {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return current++
    }
}