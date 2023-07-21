package kr.mastre.codingtest.bj

fun main() {
    val eight = 8
    //n row, m col
    val (n, m) = readln().split(' ').map(String::toInt)
    //black 1 white 0
    val board = Array(n) { IntArray(m) }
    repeat(n) {
        board[it] = readln().toCharArray().map { char -> if (char == 'B') 1 else 0 }.toIntArray()
    }
    var answer = m * n

    fun Int.isOdd(): Boolean = this % 2 == 1
    fun Int.isEven(): Boolean = !isOdd()

    fun getRepaintCount(row: Int, col: Int): Int {
        val repaintCounts = IntArray(2)
        repeat(2) {
            val startColor = it
            all@ for (rr in row until row + eight) {
                for (cc in col until col + eight) {
                    val currentColor = board[rr][cc]
                    when {
                        rr.isOdd() && cc.isOdd() && startColor != currentColor -> repaintCounts[it]++
                        rr.isOdd() && cc.isEven() && startColor == currentColor -> repaintCounts[it]++
                        rr.isEven() && cc.isOdd() && startColor == currentColor -> repaintCounts[it]++
                        rr.isEven() && cc.isEven() && startColor != currentColor -> repaintCounts[it]++
                    }
                    if (repaintCounts[it] == answer) break@all
                }
            }
        }
        return repaintCounts.min()
    }

    for (row in 0..n - eight) {
        for (col in 0..m - eight) {
            val repaintCount = getRepaintCount(row, col)
            answer = Math.min(answer, repaintCount)
        }
    }

    println(answer)
}

