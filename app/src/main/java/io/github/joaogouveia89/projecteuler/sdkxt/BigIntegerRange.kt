package io.github.joaogouveia89.projecteuler.sdkxt

import java.math.BigInteger

class BigIntegerRange(
    override val start: BigInteger,
    override val endInclusive: BigInteger
) : ClosedRange<BigInteger>, Iterable<BigInteger> {
    override operator fun iterator(): Iterator<BigInteger> =
        BigIntegerRangeIterator(this)

    //TODO: Implement to optimize prime fetching sequence generator
    /*infix fun step(stepSize: Int): BigInteger {
        val position = iterator()
        for(i in 0 until stepSize){
            if(position.hasNext()) position.next()
        }
        return position.next()
    }*/
}