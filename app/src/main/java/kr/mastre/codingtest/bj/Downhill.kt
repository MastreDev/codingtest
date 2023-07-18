package kr.mastre.codingtest.bj

/**
 * 좌, 상, 우, 하 만 이동할 수 있으며, 현재 Cell의 값 보다 낮은 곳으로 갈 수 있다.
 * input -> 세로, 가로 (M, N)
 * M 개 줄에 지도 정보가 들어옴
 * 메모리 초과?
 * dp 사용해야하는 문제.
 */
fun main() {
    val (m, n) = readln().split(" ").map(String::toInt)
    val map = Array(m) { IntArray(n) { -1 } }
    val dp = Array(m) { IntArray(n) { -1 } }

    repeat(m) {
        map[it] = readln().split(" ").map(String::toInt).toIntArray()
    }

    val answer = backTracking(0, 0, map, dp)
    println(answer)
}

private fun backTracking(
    row: Int,
    column: Int,
    map: Array<IntArray>,
    dp: Array<IntArray>
): Int {
    if (row == map.size - 1 && column == map[0].size - 1) return 1
    if (dp[row][column] != -1) return dp[row][column]

    dp[row][column] = 0

    for (k in 0 until 4) {
        val nx = row + dx[k]
        val ny = column + dy[k]

        if (map.isOut(nx, ny)) continue

        if (map[row][column] > map[nx][ny]) {
            dp[row][column] += backTracking(nx, ny, map, dp)
            println(dp[row][column])
        }
    }

    return dp[row][column]
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun Array<IntArray>.isOut(nx: Int, ny: Int): Boolean {
    if (nx < 0 || nx >= this.size || ny < 0 || ny >= this[0].size) return true
    return false
}