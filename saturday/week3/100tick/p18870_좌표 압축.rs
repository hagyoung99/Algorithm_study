// =======================================
//
// p18870 [좌표 압축]
//
// [문제]
// 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다.
// 이 좌표에 좌표 압축을 적용하려고 한다.
// Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
// X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
//
// [입력]
// 1 ≤ N ≤ 1,000,000
// -109 ≤ Xi ≤ 109
//
// [https://www.acmicpc.net/problem/18870]
//
// =======================================
// IMPORT
// =======================================
use std::cmp::Ordering;
use std::collections::HashMap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    // =======================================
    // INPUT
    // =======================================
    let mut buf = String::new();
    stdin().read_to_string(&mut buf).unwrap();
    let mut rank_mp: HashMap<i32, i32> = HashMap::new();
    let mut rank = 0;
    let points = buf
        .split_ascii_whitespace()
        .skip(1)
        .flat_map(|v| v.parse())
        .collect::<Vec<i32>>();

    let mut ascending_points = points.clone();
    ascending_points.sort();

    for p in ascending_points {
        if !rank_mp.contains_key(&p) {
            rank_mp.insert(p, rank);
            rank += 1;
        }
    }

    let mut rank_vec = vec![0; points.len()];
    for (i, p) in points.iter().enumerate() {
        rank_vec[i] = rank_mp[p];
    }

    // =======================================
    // OUTPUT
    // =======================================
    let mut output = String::new();
    for r in rank_vec {
        write!(output, "{} ", r).unwrap();
    }
    print!("{output}");
}
