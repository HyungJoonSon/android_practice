package com.dongguk.kotlinpractice

import java.time.DayOfWeek

fun main() {
    max(10, 3)
    isHoliday("토")
}

// 자바와 다르게 코틀린은 if문이 Statement가 아닌 Expression이 된다.
// 따라서 If문의 기본값은 Unit Value이다.

fun max(a: Int, b: Int) {
//    if (a > b) {
//        println(a)
//    } else {
//        println(b)
//    }
//
//    val result = if (a > b) {
//        a
//    } else {
//        b
//    }
    // 이렇게 짧게도 가능
    val result = if (a > b) a else b
    println(result)
}

// Switch 문 == When 문
// when 구문 또한, Statement 가 아닌 expression 이다.
fun isHoliday(dayOfWeek: String) {
    // 형태 1
    /*when(dayOfWeek) {
        "월" -> false
        "화" -> false
        "수" -> false
        "목" -> false
        "금" -> false
        "토" -> true
        "일" -> true
    }*/

    // 형태 2
    /* when(dayOfWeek) {
        "월",
        "화",
        "수",
        "목",
        "금" -> false
        "토",
        "일" -> true
    } */


    // 형태 3
    // 주의사항 : expression으로 사용하게 될 때, else가 없다면 null이 생기므로 else가 필요하다.
    /* val result = when(dayOfWeek) {
        "토",
        "일" -> true
        else -> false
    } */

    // 형태 4
    // 다시 그 값을 사용해야할 때, val을 사용하여 재사용한다.
    val result = when(val day = dayOfWeek) {
        "토",
        "일" -> if (day == "토") "좋아" else "너무 좋아"
        // 숫자 범위인 경우 다음을 따른다.
        // in 2 .. 4 -> {}
        // List은 다음을 따른다.
        // in listOf("월", "화") -> {}
        else -> "안 좋아"
    }

    println(result)
}