package io.github.joaogouveia89.projecteuler.problems.base

import java.math.BigInteger
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

abstract class MathSequence(private val roof: BigInteger) {

    protected abstract val sequenceWork: Thread
    protected val sequence = mutableListOf<BigInteger>()

    private val arrayOpLock: Lock = ReentrantLock()
    private var sequenceSize = 0

    abstract fun generateSequence()

    open fun interruptGenerateProcess() {
        sequenceWork.interrupt()
    }

    @Throws(InterruptedException::class)
    open fun sequenceSum(): BigInteger? {
        sequenceWork.join()
        return sequence.sumOf { it }
    }

    @Throws(InterruptedException::class)
    open fun sequenceSum(lambda: (BigInteger) -> Boolean): BigInteger {
        sequenceWork.join()
        return sequence
            .filter(lambda)
            .sumOf { it }
    }

    protected open fun add(item: BigInteger) =
        synchronized(arrayOpLock) {
            sequence.add(item)
            sequenceSize++
        }


    open fun get(position: Int): BigInteger = synchronized(arrayOpLock) { return sequence[position] }

    open fun sequenceSize(): Int = synchronized(arrayOpLock) { return sequenceSize }

    protected open fun addAll(items: List<BigInteger>) =
        synchronized(arrayOpLock) {
            sequence.addAll(items)
            sequenceSize += items.size
        }


    open operator fun contains(item: BigInteger): Boolean = synchronized(arrayOpLock) { return sequence.contains(item) }
}