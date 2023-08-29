package org.wrongwrong

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import kotlin.random.Random

@State(Scope.Benchmark)
open class Benchmark {
    lateinit var arr: Array<String>

    @Setup(Level.Trial)
    fun setUp() {
        arr = Array(5) { Random.nextInt(10).toString() }
    }

    private inline fun _vararg(vararg args: String) = args.joinToString(separator = ", ")

    private inline fun _list(args: List<String>) = args.joinToString(separator = ", ")

    @Benchmark
    fun vararg() = _vararg(*arr)

    @Benchmark
    fun list() = _list(arr.asList())
}
