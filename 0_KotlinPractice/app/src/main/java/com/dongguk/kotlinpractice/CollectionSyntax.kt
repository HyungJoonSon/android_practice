package com.dongguk.kotlinpractice

fun main() {
    // Collection의 값이 변경 한 경우(Mutable[Collection]) && Collection의 값이 변경 불가능한 경우([Collection] Of)

    // 코틀린의 List는 다양한 값을 넣울 수 있음
    val list = mutableListOf<Any>(1,2,3,4,5)
    list.add(6)
    list.addAll(listOf(7,8,9))

    val list1 = listOf(1,2,3,4)
    // list1.add() 변경이 불가능해서 함수가 없고 호출만 가능

    println(list.joinToString(", "))

    // 확장함수 10 곱한 List를 새롭게 만듬
    println(list1.map { it * 10}.joinToString(", "))
    // map은 인덱스로 넣을 수 잇고, put으로 넣을 수 있다.
    val map = mutableMapOf<Int, String>((1 to "안녕"), (1 to "하세요"))
    val map1 = mapOf((1 to "안녕"), (1 to "하세요"))

    map[3] = "호잇"
    map[100] = "호이"

}