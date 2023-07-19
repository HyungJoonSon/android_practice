package com.dongguk.kotlinpractice

fun main() {
    /**
     * 확장함수란? Extension Function
     * 1. 기존에 정의되어 있는 클래스에 함수를 추가하는 기능
     */
    val test = Test()
    test.hi()
}

// 해당 클래스에 함수를 추가함 (자바처럼 상속을 안 받아도 됨)
fun Test.hi() = println("하이")

class Test() {
    fun hello() = println("안녕")
    fun bye() = println("잘가")
}