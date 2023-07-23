package kr.mastre.codingtest.bj

/*
0으로 선언된 곳 중에 1을 세개 대입한다.
다 넣어 봐야 안다.
3 ≤ N, M ≤ 8
바이러스가 있는 곳은 2로 표현되는데,
2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
2 <= x <= 10
0의 갯수는 3이상이다.
(3, 0) 가능?
설계
1. 2의 위치를 찾아서 상하좌우를 살펴 3개의 벽으로 격리 시키는 것이 베스트
2. 만약 1번처럼 하지 못한다면, 벽으로 둘러쌓인 공간을 최대한 확보하는 것이 베스트

 */
fun main() {
    val (n, m) = readln().split(' ').map(String::toInt)
    val map = Array(n) { IntArray(m) }
    repeat(n) {
        map[it] = readln().split(' ').map(String::toInt).toIntArray()
    }
    val aWalls = map.flatMapIndexed { i: Int, ints: IntArray ->
        ints.withIndex().filter { it.value == 0 }.map { i to it.index }
    }

    val wallC = mutableListOf<List<Pair<Int, Int>>>()

    fun getWallCombinations(
        aWalls: List<Pair<Int, Int>>,
        selected: List<Pair<Int, Int>> = listOf(),
        index: Int = 0,
        r: Int = 3
    ) {
        if (selected.size == r) {
            wallC.add(selected)
            return
        }
        for (i in index until aWalls.size) {
            val newItem = aWalls[i]
            if (!selected.contains(newItem)) {
                getWallCombinations(aWalls, selected + newItem, i + 1, r)
            }
        }
    }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    fun transitionVirus(r: Int, c: Int, newMap: Array<IntArray>, visited: Array<BooleanArray>) {
        newMap[r][c] = 2
        visited[r][c] = true

        for (k in 0 until 4) {
            val rd = r + dx[k]
            val cd = c + dy[k]

            if (rd !in 0 until n || cd !in 0 until m) continue

            if (newMap[rd][cd] == 0 && !visited[rd][cd]) {
                transitionVirus(rd, cd, newMap, visited)
            }
        }
    }

    fun deepCopy(old: Array<IntArray>): Array<IntArray> {
        return Array(old.size) {
            old[it].copyOf()
        }
    }

    getWallCombinations(aWalls)
    var answer = 0
    val visited = Array(n) { BooleanArray(m) }

    wallC.forEach { walls ->
        val newMap = deepCopy(map)
        walls.forEach {
            newMap[it.first][it.second] = 1
        }
        visited.forEach { it.fill(false) }

        for (i in newMap.indices) {
            for (j in newMap[i].indices) {
                if (newMap[i][j] == 2 && !visited[i][j]) {
                    transitionVirus(i, j, newMap, visited)
                }
            }
        }
        answer = maxOf(answer, newMap.flatMap { it.toList() }.filter { it == 0 }.size)

    }
    println(answer)
}