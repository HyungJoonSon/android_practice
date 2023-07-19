package com.dongguk.kotlinpractice

fun main() {
    // let, run, apply, also, with

    // 1. let
    // 수신객체.let { it(user 가능) ->
    //
    // } 마지막 줄이 return 값이 됨(Any)
    val user : UserTwo? = UserTwo("채상아", 10, true)
    
    // 앨비스 연산자를 통해 nullable한 값이 나옴
    val age = user?.let { user ->
        user.age
    }

    println(age)

    // 2. run
    // 수신객체.run {
    //
    // } 마지막 줄이 return 값이 됨(Any)

    val kid = UserTwo("아이", 4, false)
    val kidAge = kid.run {
        this.age
    }

    println(kidAge)

    // 3. apply
    // 수신객체.apply {
    // 
    // } 마지막 줄이 return 값이 됨(수신객체와 같은 객체가 나옴)

    val female = UserTwo("영지", 20, true, true)
    val femaleValue = female.apply {
        hasGlasses = false
    }

    println(femaleValue.hasGlasses)

    // 4. also(공식문서에서는 log를 찍을 때 권장함)
    // 수신객체.let { it(user 가능, local variable 가능) ->
    //
    // } 마지막 줄이 return 값이 됨(수신객체와 같은 객체가 나옴)
    val male = UserTwo("민수", 27, false, true)
    val maleValue = male.also {
        // hasGlasses = false
        println(it.name)
    }

    // 5. with
    // with(수신객체) { this로 접근함
    //
    // } 마지막 줄이 return 값이 됨(Any)
    
    val result = with(male) {
        hasGlasses = false
        true
    }

    println(result)
}

class UserTwo (
    val name : String,
    val age: Int,
    val gender: Boolean,
    var hasGlasses : Boolean = true
)