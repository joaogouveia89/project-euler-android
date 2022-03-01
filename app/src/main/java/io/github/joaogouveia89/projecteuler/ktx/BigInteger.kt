package io.github.joaogouveia89.projecteuler.ktx

import io.github.joaogouveia89.projecteuler.sdkxt.BigIntegerRange
import java.math.BigInteger

// thanks to https://stackoverflow.com/questions/55773033/loop-over-biginteger-values-using-foreach-in-kotlin

operator fun BigInteger.rangeTo(other: BigInteger) =
    BigIntegerRange(this, other)