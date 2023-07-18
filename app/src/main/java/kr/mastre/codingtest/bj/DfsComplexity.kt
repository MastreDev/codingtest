package kr.mastre.codingtest.bj

import java.io.BufferedWriter
import java.io.OutputStreamWriter


private var size = 0
private var visited = arrayOf(booleanArrayOf())

fun main(args: Array<String>) {
    size = readln().toInt()
    val map = Array(size) { intArrayOf() }
    repeat(size) {
        map[it] = (readln().toList().map { char -> char.digitToInt() }.toIntArray())
    }
    visited = Array(size) { BooleanArray(size) }

    val allComplexity = mutableListOf<Int>()

    for (i in 0 until size) {
        for (j in 0 until size) {
            if (map[i][j] == 1 && !visited[i][j]) {
                val count = mutableListOf<Int>()
                dfs(i, j, map, count)
                allComplexity.add(count.size)
            }
        }
    }

    allComplexity.sort()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("${allComplexity.size}\n")
    allComplexity.forEach {
        bw.write("$it\n")
    }
    bw.flush()
}

private fun dfs(i: Int, j: Int, map: Array<IntArray>, count: MutableList<Int>) {
    visited[i][j] = true
    count.add(1)

    //안드로이드니까 좌, 상, 우, 하 로 변경해보자
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    for (k in 0 until 4) {
        val nx = i + dx[k]
        val ny = j + dy[k]

        if (checkOut(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
            dfs(nx, ny, map, count)
        }
    }

}

private fun checkOut(i: Int, j: Int): Boolean {
    if (i < 0 || i >= size || j < 0 || j >= size) return false
    return true
}