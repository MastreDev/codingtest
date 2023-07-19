package kr.mastre.codingtest.bj
//
///*
//바다는 0이다.
//그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다
//만약 2인 조각이 3부분 바다로 둘러 쌓여 있었다면, -1이 되는데 이는 0으로 변경해야 한다.
//재귀를 도는 조건은 -> 좌상우하에 근접한 0의 갯수다.
//"한 덩어리"의 빙산이 주어질 때, 이 빙산이 "두 덩어리" 이상으로 분리되는 "최초의 시간(년)"을 구하는 프로그램을 작성하시오
// */
//fun main() {
//    println(readln().split(" ").map(String::toFloat).sum())
//    val (n, m) = readln().split(" ").map(String::toInt)
//    val map = Array(n) { readln().split(" ").map(String::toInt).toIntArray() }
//    var yearCount = 0
//    var massCount = 0
//    val dy = intArrayOf(0, -1, 0, 1)
//    val dx = intArrayOf(-1, 0, 1, 0)
//
//    fun meltBerg(point: Pair<Int, Int>) {
//        val visited = Array(n) { BooleanArray(m) }
//
//        fun dfs(row: Int, column: Int) {
//            visited[row][column] = true
//            var seaCount = 0
//            for (k in 0 until 4) {
//                val dRow = row + dy[k]
//                val dColumn = column + dx[k]
//                if (dRow !in 0 until n || dColumn !in 0 until m || visited[dRow][dColumn]) continue
//                if (map[dRow][dColumn] == 0 && !visited[dRow][dColumn]) seaCount++
//                if (map[dRow][dColumn] == 0) continue
//                dfs(dRow, dColumn)
//            }
//            map[row][column] = Math.max(map[row][column] - seaCount, 0)
//        }
//
//        dfs(point.first, point.second)
//        yearCount++
//    }
//
//    fun findIceBerg() {
//        val visited = Array(n) { BooleanArray(m) }
//        fun dfs(row: Int, column: Int) {
//            visited[row][column] = true
//            for (k in 0 until 4) {
//                val dRow = row + dy[k]
//                val dColumn = column + dx[k]
//                if (dRow !in 0 until n || dColumn !in 0 until m || visited[dRow][dColumn]) continue
//                if (map[dRow][dColumn] == 0) continue
//                dfs(dRow, dColumn)
//            }
//        }
//
//        var findMass = 0
//        visited.forEach { it.fill(false) }
//        for (i in map.indices) {
//            for (j in map[i].indices) {
//                if (map[i][j] != 0 && !visited[i][j]) {
//                    dfs(i, j)
//                    findMass++
//                }
//            }
//        }
//        massCount = findMass
//    }
//
//    while (massCount < 2) {
////     시작점을 찾는다.
////     시작점으로 부터 1년 뒤 빙하의 모습을 만든다. -> map의 정보 update
////     덩어리를 찾고
////     못 찾으면 1년의 시간을 보낸다.
//        meltBerg(map.getStartPoint())
//        findIceBerg()
//        if (map.sumOf { it.sum() } == 0) {
//            yearCount = 0
//            break
//        }
//    }
//    println(yearCount)
//}
//
//private fun Array<IntArray>.getStartPoint(): Pair<Int, Int> {
//    for (i in this.indices) {
//        for (j in this[i].indices) {
//            if (this[i][j] != 0) {
//                return i to j
//            }
//        }
//    }
//    return 0 to 0
//}
//fun main()=print(readln().trim().split(' ').size)
fun main()=print(readln().trim().split(' ').takeIf{it.firstOrNull()?.isNotEmpty()==true}?.size?:0)
