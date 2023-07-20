package kr.mastre.codingtest.bj

/*
Queen의 이동경로는 가로로 죽 가거나 세로로 죽 갈 수 있고, 대각선 좌상, 우상, 좌하, 우하 까지 이동 가능하다.
r,c 값이 있으면, loop를 돌면서 nextCell이 r과 같으면 안되고, c와 같으면 안되고,
 상 좌(r-1, c-1)
 상 우(r-1, c+1)
 하 좌(r+1, c-1)
 하 우(r+1, c+1)
 이어도 안된다.

 (Math.abs(row - r) == Math.abs(col - c))
 abs(x - x1) == abs(y - y1) 이면, (x1, y1)은 (x,y)의 대각선에 위치한 걸로 판단 가능하다.
 */
fun main() {
    val rc = readln().toInt()
    val cols = IntArray(rc) { -1 }
    var answer = 0

    fun isPromising(r: Int, c: Int): Boolean {
        for (i in 0 until r) {
            if (cols[i] == c) return false
            if (Math.abs(i - r) == Math.abs(cols[i] - c)) return false
        }
        return true
    }

    fun backtracking(row: Int) {
        if (row == rc) {
            answer++
            return
        }

        for (col in 0 until rc) {
            if (isPromising(row, col)) {
                cols[row] = col
                backtracking(row + 1)
                cols[row] = -1
            }
        }
    }

    backtracking(0)
    println(answer)
}



