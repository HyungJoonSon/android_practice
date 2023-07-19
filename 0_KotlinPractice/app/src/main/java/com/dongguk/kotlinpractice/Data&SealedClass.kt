package com.dongguk.kotlinpractice

fun main() {
    val person = Person("수지", 24)
    val dog = Dog("해피", 3)

    println(person.toString())
    println(dog.copy(age = 5).toString())
    println(dog.toString())

    val cat: Cat = WhiteCat()
    val result = when(cat) {
        is BlueCat -> "blue"
        is RedCat -> "red"
        is GreenCat -> "green"
        is WhiteCat -> "white"
    }

    println(result)
}

class Person(
    val name: String,
    val age: Int
)

// Data 클래스는 데이터를 담기 위한 클래스
// 1. 기본 메서드 자동 생성, 1개 이상의 속성, 상속 불가능

data class Dog(
    val name: String,
    val age: Int
)

// Sealed 클래스는 추상 클래스이며 상속받은 자식 클래스으 ㅣ종류를 제한함
// when과 함께 쓸 때, 장점을 느낌
sealed class Cat
class BlueCat : Cat()
class RedCat : Cat()
class GreenCat : Cat()
class WhiteCat : Cat()