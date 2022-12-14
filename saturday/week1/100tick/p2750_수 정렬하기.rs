// =======================================
//
// p2750 [수 정렬하기]
//
// [문제]
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 수가 주어진다.
// 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
// [출력]
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
// [https://www.acmicpc.net/problem/2750]
//
// =======================================
// IMPORT
// =======================================
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    // =======================================
    // INPUT
    // =======================================
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    input.clear();
    stdin().read_to_string(&mut input).unwrap();

    // =======================================
    // CONVERT STRING TO Vec<i32>
    // =======================================
    let mut nums = input
        .split_ascii_whitespace()
        .flat_map(|v| v.parse())
        .collect::<Vec<i32>>();
    // =======================================
    // SORT
    // =======================================
    nums.sort();

    // =======================================
    // WRITE TO OUTPUT
    // =======================================
    let mut output = String::new();
    for n in nums {
        writeln!(output, "{}", n.to_string()).unwrap();
    }

    // =======================================
    // OUTPUT
    // =======================================
    println!("{output}");
}
