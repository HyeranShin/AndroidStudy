package com.hyeran.androidstudy.kotlin

data class Person(
    var name: String? = null,
    var age: Int? = null
)

class ApplyWithLetAlsoRun {

    val person = Person()

    fun main() {
        print(person.name)
        print(person.age)
    }

    /**
     * apply
     * 호출 시 수신 객체 입력: receiver로 암시적 전달
     * 코드 블록으로 수신 객체 전달: receiver로 암시적 전달
     * 반환: 전달 받은 수신 객체
     */
    fun apply() {
        val newPerson = person.apply {
            print(name)
            print(age)
        }

        /** 수신 객체의 프로퍼티만을 사용하는 경우 ex) 객체의 초기화 **/
        val hyeran = Person().apply {
            name = "hyeran"
            age = 24
        }
    }

    inline fun <T> T.apply(block: T.() -> Unit): T {
        block()
        return this
    }

    /**
     * with
     * 호출 시 수신 객체 입력: parameter로 명시적 전달
     * 코드 블록으로 수신 객체 전달: receiver로 암시적 전달
     * 반환: 코드 블록의 수행 결과
     */
    fun with() {
        /** Non-nullable 수신 객체이고, 결과가 필요하지 않은 경우 **/
        val newPerson = with(person) {
            print(name)
            print(age)
        }
    }

    inline fun <T, R> with(receiver: T, block: T.() -> R): R {
        return receiver.block()
    }

    /**
     * let
     * 호출 시 수신 객체 입력: receiver로 암시적 전달
     * 코드 블록으로 수신 객체 전달: parameter로 명시적 전달
     * 반환: 코드 블록의 수행 결과
     */
    fun let() {
        val newPerson = person.let {
            print(it.name)
            print(it.age)
        }

        /** 지정된 값이 null이 아닌 경우에 코드를 실행 **/
        person.name?.let {
            print(it)
        }
        /** Nullable 객체를 다른 Nullable 객체로 변환하는 경우 **/
        /** 단일 지역 변수의 범위를 제한하는 경우 **/
    }

    inline fun <T, R> T.let(block: (T) -> R): R {
        return block(this)
    }

    /**
     * also
     * 호출 시 수신 객체 입력: receiver로 암시적 전달
     * 코드 블록으로 수신 객체 전달: parameter로 명시적 전달
     * 반환: 전달 받은 수신 객체
     */
    fun also() {
        val newPerson = person.also {
            print(it.name)
            print(it.age)
        }
    }

    /** 객체의 사이드 이펙트를 확인하거나 수신 객체의 프로퍼티에 데이터를 할당하기 전 유효성을 검사할때 **/
    class Book(author: Person) {
        val author = author.also {
            requireNotNull(it.name)
            requireNotNull(it.age)
        }
    }

    inline fun <T> T.also(block: (T) -> Unit): T {
        block(this)
        return this
    }

    /**
     * run
     * 호출 시 수신 객체 입력: receiver로 암시적 전달
     * 코드 블록으로 수신 객체 전달: receiver로 암시적 전달
     * 반환: 코드 블록의 수행 결과
     */
    fun run() {
        val newPerson = person.run {
            print(name)
            print(age)
        }

        /** 어떤 값을 계산하거나 여러개의 지역변수의 범위를 제한 **/
        /** 매개변수로 전달된 명시적 수신객체를 암시적 수신객체로 변환할때 **/
    }

    inline fun <T, R> T.run(block: T.() -> R): R {
        return block()
    }
}