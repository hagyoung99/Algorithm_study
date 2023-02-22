fun main() {
    val N = readln().toInt()

    var l = 0
    var r = 0
    var ans = 1
    var sum = 0

    while (r < N) {

        when {
            sum < N -> {
                r++
                sum += r
            }

            sum > N -> {
                sum -= l
                l++
            }

            else -> {
                ans++

                sum += -l++ + ++r
            }
        }
    }

    println(ans)
}
