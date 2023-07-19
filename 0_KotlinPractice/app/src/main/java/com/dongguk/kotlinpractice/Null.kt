package com.dongguk.kotlinpractice

fun main() {
    // 밑은 null을 넣을 수 없음을 뜻한다.
    var temp : String = "상아"
    var number : Int = 10

    // 밑은 ?을 붙이므로써 null을 사용할 수 있다.
    var nickname: String? = "테스트"
    var secondNumer: Int? = null

    // 자바 버전의 null 체킹
    var result = if (nickname == null) {
        "값이 없음"
    } else {
        nickname
    }

    println(result)

    // 코틀린 버전의 null 체킹(Elvis Operation)
    nickname = null;
    var result2 = nickname?: "값이 없음"

    println(result2)

    // 코틀린 버전의 null 체킹 2
    // ?일 경우는 null이면 뒤의 함수를 실행하지 않음
    // !!의 경우는 무조건 null이 아닌 상황이 있음 그 때 사용. 즉, 무조건 객체를 참조하고 있을 때를 생각. 하지만 보통 사용하지 않음
    val size = nickname?.length

    println(size)
}