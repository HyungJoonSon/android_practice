package com.dongguk.kotlinpractice

fun main() {
    println("Hellow world!!")
    test()
    val result = test2(1)
    println(result)
    test3(id = "상아님", name = "채상아", nickname = "상아")
}

/**
 * Kotlin 의 경우 Unit 이라는 Default Type 이 생략되어 있다.
 * 이 뒤에 Int 등을 넣으면 리턴을 만들 수 있다.
 */
fun test() {
    println("test")
}

fun test2(a: Int, b: Int = 3) : Int {
    println(a+b)
    return a+b;
}

// 간단한 함수는 Single Expression 으로 나타낼 수 있다.
fun test3(name: String, nickname: String, id: String) = println(name + nickname + id)