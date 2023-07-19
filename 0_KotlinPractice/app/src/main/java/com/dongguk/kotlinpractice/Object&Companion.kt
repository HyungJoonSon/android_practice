package com.dongguk.kotlinpractice

fun main() {
    println(Counter.count)

    Counter.countUp()
    Counter.countUp()

    println(Counter.count)
    Counter.hello()

    println(Book.NAME)
    println(Book.builder())
}
// Object: 클래스를 정의함과 동시에 객체를 생성
// 싱글통을 쉽게 만들수 있고, 생성자 사용 불가능, [속성, 메소드, 초기화] 사용 가능, 상속 받을 수 있음
// 보통 ErrorCode 작성할 때 사용

object Counter : Hello() {
    init {
        println("카운터 초기화")
    }

    var count = 0;

    fun countUp() {
        count++;
    }
}

open class Hello() {
    fun hello() = println("하이용")
}

// Companin Object 동반객체이며 Java static과 같음
// 클래스에서 하나만 생성 가능
class Book() {
    companion object Novel {
        const val NAME = "hello"

        fun builder() = Book()
    }
}
