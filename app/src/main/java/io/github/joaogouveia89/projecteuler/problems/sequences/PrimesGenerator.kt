package io.github.joaogouveia89.projecteuler.problems.sequences

import io.github.joaogouveia89.projecteuler.problems.base.MathSequence
import io.github.joaogouveia89.projecteuler.ktx.rangeTo
import java.math.BigInteger

class PrimesGenerator(private val roof: BigInteger): MathSequence(roof) {
    override val sequenceWork = Thread{
        var isOdd = true
        addAll(listOf(
            BigInteger.ONE,
            BigInteger("2")
        ))

        for (i in BigInteger("3")..BigInteger(roof.toString())) {
            if(isOdd){
                if(isPrime(i)){
                    add(i)
                }
            }
            isOdd = !isOdd
        }
    }

    private fun isPrime(num: BigInteger): Boolean {
        var isPrime = false
        for(i in sequence){
            isPrime = i != BigInteger.ONE && num.mod(i) == BigInteger.ZERO
            if(!isPrime) break
        }
        return isPrime
    }

    override fun generateSequence() = sequenceWork.start()
}