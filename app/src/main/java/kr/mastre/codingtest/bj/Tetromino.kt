package kr.mastre.codingtest.bj

/*
무식하게 풀꺼다. 다만 dfs에서 다음 탐색을 때, 상하좌우 찾았던 거처럼 각 모양별 찾을 수 있는 방법을 찾아서
탐색해보는 걸로.
 */
fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val map = Array(n) { IntArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    repeat(n) {
        map[it] = readln().split(' ').map(String::toInt).toIntArray()
    }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    var answer = 0

    fun dfs(row: Int, col: Int, cnt: Int, sum: Int) {
        if (cnt == 4) {
            answer = maxOf(answer, sum)
            return
        }

        for (k in 0 until 4) {
            val dr = row + dx[k]
            val dc = col + dy[k]

            if (dr !in 0 until n || dc !in 0 until m) continue

            if (visited[dr][dc]) continue

            if (cnt == 2) {
                visited[dr][dc] = true
                dfs(row, col, cnt + 1, sum + map[dr][dc])
                visited[dr][dc] = false
            }

            visited[dr][dc] = true
            dfs(dr, dc, cnt + 1, sum + map[dr][dc])
            visited[dr][dc] = false
        }
    }

    for(i in map.indices) {
        for(j in map[i].indices) {
            if(!visited[i][j]){
                visited[i][j] = true
                dfs(i, j, 1, map[i][j])
                visited[i][j] = false
            }
        }
    }
    println(answer)
}

