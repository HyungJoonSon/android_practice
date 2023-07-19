package com.dongguk.kotlinpractice

fun main() {
    val a = 10
    val name = "안녕"
    val isHigh = true
    
    // 자바 버전
    println(a.toString() + name + isHigh.toString())
    println(String.format("%s %d", name, a))
    
    // 코틀린 버전( [$] 를 넣으면 자동으로 string으로 바꿔줌)
    // 중괄호를 넣으면 함수도 넣을 수 있음
    println("$a ${name.length} $isHigh")
}