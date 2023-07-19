package com.dongguk.kotlinpractice

fun main() {
    // 자바 문법
    /* for (int i = 0; i < 11; i++) {

    } */

    // 코틀린 문법
    // 끝 숫자를 넣는 경우
    // range를 넣는다. 이것과 같은 것은 1..10 == IntRange(1, 10)
    for (i in IntRange(1, 10)) {
        print(i)
        print(".")
    }

    println()

    // 끝 숫자를 넣지 않는 경우
    for (i in 1 until 10) {
        print(i)
        print(".")
    }
    println()

    // 중간에 넘기는 숫자를 1이 아닌 다른 것으로 할 경우
    for (i in 1..10 step (2)) {
        print(i)
        print(".")
    }

    println()

    // 10부터 내려갈 경우
    for (i in 10 downTo 1) {
        print(i)
        print(".")
    }

    println()

    // 10부터 내려갈 경우
    // 스탭은 두가지로 나눌 수 있다. (i in 10..1 step(-2)) == (i in 10 downTo 1 step(2))
    for (i in 10 downTo 1 step (2)) {
        print(i)
        print(".")
    }

    println()

    // while은 비슷하다.
    var c = 1
    while (c < 11) {
        print(c++)
        print(".")
    }
}