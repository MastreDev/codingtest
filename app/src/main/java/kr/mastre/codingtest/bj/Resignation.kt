package kr.mastre.codingtest.bj

fun main() {
    val n = readln().toInt()
    val t = Array(n) { 0 }
    val p = Array(n) { 0 }

    //Do BP
    repeat(n) {
        readln().split(' ').map(String::toInt).also { (a, b) ->
            t[it] = a
            p[it] = b
        }
    }

    var answer = 0
    fun calc(cur: Int, sum: Int) {
        if (cur >= n) {
            answer = maxOf(answer, sum)
            return
        }

        for (i in cur + t[cur] until n + 1) {
            calc(i, sum + p[cur])
        }
    }

    for (i in 0 until n) {
        calc(i, 0)
    }
    println(answer)
}

