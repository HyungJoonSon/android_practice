package com.dongguk.kotlinpractice

fun main() {
    println(check("안녕"))
    println(check(10))
    println(check(true))

    cast("안녕")
    cast(10)

    println(smartCast("안녕"))
    println(smartCast(10))
    println(smartCast(true))
}

fun check(a: Any) : String {
    // type을 체크할 때 코틀린은 is를 사용

    // if 버전
    /* return when (a) {
        is String -> {
            "문자열"
        }
        is Int -> {
            "숫자"
        }
        else -> {
            "몰라요"
        }
    } */

    // when 버전
    return when (a) {
        is String -> {
            "문자열"
        }
        is Int -> {
            "숫자"
        }
        else -> {
            "몰라요"
        }
    }
}
fun cast(a : Any) {
    // 아래 문법에서 as는 앞의 값을 String으로 받겠다는 뜻
    // 앨비스 연산자를 통해 String이 아닐 경우 null로 바꿈
    val result = (a as? String)?: "실패"
    println(result)
}

fun smartCast(a : Any) : Int{
    // type 체킹 이후 해당 type 처럼 사용 가능한 것을 보여줌
    return if (a is String) {
        a.length
    } else if(a is Int) {
        a.dec()
    } else {
        -1
    }
}