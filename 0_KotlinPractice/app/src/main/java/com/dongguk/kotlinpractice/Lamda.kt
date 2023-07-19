package com.dongguk.kotlinpractice

fun main() {
    /**
     * 람다란?
     * 1. 익명 함수
     * 2. 변수처럼 사용되서, 함수의 argument, return이 될 수 있다.
     * 3. 한번 사용되고, 재사용되지 않는 함수
     */

    val a = fun() = println("hello")

    // 함수 조각
    val b : (Int) -> Int = { it * 10 }

    // 둘중 하나에는 Type이 있어야 한다
    val d = { i : Int, j : Int -> i * j }

    println(b(10))
    println(d(10, 20))

    hello(10, b)
}

// Input, Output에 모두 람다를 넣을 수 있다.
fun hello(a: Int, b: (Int) -> Int) : (Int) -> Int {
    println(a)
    println(b(20))

    return b
}

