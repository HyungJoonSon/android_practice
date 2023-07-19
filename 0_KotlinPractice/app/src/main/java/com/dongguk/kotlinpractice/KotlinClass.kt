package com.dongguk.kotlinpractice

fun main() {
    val user = User("채상아")
    println(user.age)
    val kid = Kid("아이", 3, "male")
}

// 뒤에 ()는 주 생성자로서 사용 가능
// private 가능
// 없다면 그냥 public
// {} 는 구현부가 필요할 때만 구현
open class User(open val name : String, open val age : Int = 100)

// 상속이 필요하다면 open 을 붙인다.
// 내부에 있다면 세컨드 생성자라고 부른다.
// 클래스를 생성할 때, 생성자 전에 제일 먼저 호출되는 함수를 init이라고 한다.
// 보통 init은 fragment를 초기화 할 때 사용한다!!! 생성 전에 초기화 해줘야 하는 것들에 대하여
class Kid(override val name : String, override val age: Int) : User(name, age) {
    var gender: String = "female"

    init {
        println("초기화 중 입니다.")
    }
    constructor(name: String, age: Int, gender: String) : this(name, age) {
        this.gender = gender
        println("부 생성자 호출 중 입니다.")
    }
}