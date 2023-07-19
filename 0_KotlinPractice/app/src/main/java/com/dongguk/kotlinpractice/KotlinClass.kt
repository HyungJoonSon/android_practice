package com.dongguk.kotlinpractice

fun main() {
    val user = User("채상아")
    println(user.age)
}

// 뒤에 ()는 생성자
// private 가능
// 없다면 그냥 public
// {} 는 구현부가 필요할 때만 구현
class User(private val name : String, val age : Int = 100)