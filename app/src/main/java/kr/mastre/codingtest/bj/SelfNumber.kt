package kr.mastre.codingtest.bj
/*
75 라는 수는 -> 75 + 7 + 5 를 더해 87이 된다.
이때, 75는 87의 생성자이다.
예를들어 101의 생성자는 91, 100 두가지일 수 있다.
이 중, 생성자가 없는 숫자를 셀프넘버라 한다.
셀프넘버는 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97 이다.
do !
1. make function D
생성자 x -> x + x.split[0] + x.split[1]
function d(x) 는 x + x.split[x].sum() 이다.
2. 일단 1부터 10000 까지 모든 수를 돌면서 d의 결과값과 함께 hashmap에 저장하고.
hashmap 중 value가 0인 아이들을 추려보자.
 */

fun main() {
    val keys = (1..10000)
        .map { it to d(it) } // O(N)
        .groupingBy { it.second }// O(N)
        .eachCount()

    (1..10000)
        .filter { !keys.containsKey(it) }
        .forEach { println(it) }
}

fun d(x: Int): Int {
    return x + x.toString().toCharArray().sumOf { it.digitToInt() }
}