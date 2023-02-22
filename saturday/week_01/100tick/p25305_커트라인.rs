// =======================================
//
// p25305 [커트라인]
//
// [문제]
// 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
// 이들 중 점수가 가장 높은 k명은 상을 받을 것이다.
// 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
// 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
//
// [입력]
// 첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
// 둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
//
// [출력]
// 상을 받는 커트라인을 출력하라.
//
// [제한]
// 1 <= N <= 1000
// 1 <= k <= N
// 0 <= x <= 10000
//
// [https://www.acmicpc.net/problem/25305]
//
// =======================================
// IMPORT
// =======================================
use std::cmp::Ordering;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    // =======================================
    // INPUT
    // =======================================
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    let nums = input
        .split_ascii_whitespace()
        .flat_map(|v| v.parse())
        .collect::<Vec<i32>>();
    // let N = nums.get(0).unwrap();
    let k = nums.get(1).unwrap();
    input.clear();

    stdin().read_to_string(&mut input).unwrap();
    // =======================================
    // CONVERT STRING TO Vec<i32>
    // =======================================
    let mut scores = input
        .split_ascii_whitespace()
        .flat_map(|v| v.parse())
        .collect::<Vec<i32>>();
    // =======================================
    // SORT
    // =======================================
    scores.sort_by(|a, b| b.cmp(a));

    // =======================================
    // OUTPUT
    // =======================================
    println!("{}", scores[(*k - 1) as usize]);
}
