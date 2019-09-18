package com.kona.leodemo.ui.generic

/**
 * parkkh on 2019-08-21
 *
 */

interface BaseView
interface ProductView: BaseView
class Presenter<out T>  //형식 매개변수 선언 위치에서 변량 한정자를 정의한다.

//사용
var presenter = Presenter<BaseView>()
var productPresenter = Presenter<ProductView>()
//presenter = productPresenter //정상: 변량 한정자 out으로 정상 동작 함.


class ConsumerProducer<in T, out R> {
    fun consumeItemT(t: T): Unit {}
    fun consumeItemR(): Unit {}

}

class ExampleUnitTest {

    private fun showResult(body: (Int, Int) -> Int) {
        println(body(1, 2))
    }


    fun test() {
        showResult(::sum)
        showResult(::minus)
        showResult(::multiply)
        showResult(::division)


        val i: Int = 1
        val ml: MutableList<Number> = mutableListOf<Number>(1, 2, 3)
        ml.add(i)
    }



}

fun sum(a: Int, b: Int) = a + b
fun minus(a: Int, b: Int) = a - b
fun multiply(a: Int, b: Int) = a * b
fun division(a: Int, b: Int) = a / b

interface Transformer<T> {
    fun transform(t: T) : T
}

class Producer<out T>(val t: T) {

}
val stringProducer = Producer("String")
val anyProducer: Producer<String> = stringProducer






