package com.dongguk.kotlinpractice

// null을 사용하지 않기 위해 1번이 아닌 2번부터 사용
// 1. var text : String? = null

// lateinit의 경우 객체만 할 수 있음 (Variable)
// 2. 타입만 지정해주면 됨
lateinit var text : String

// 3. Lazy는 Lamda 식이며 Value에 사용
// value는 선언과 동시에 초기화 해야한다
// 초기화될 때는 해당 값을 사용할 때 한다. 즉, 사용하지 않으면 메모리에 안 올림
val test : Int by lazy {
    println("초기화 중")
    100
}


fun main() {
    text = "name"

    println(text)
    println("첫번째 부른 값 $test")
    println("두번째 부른 값 $test")
}