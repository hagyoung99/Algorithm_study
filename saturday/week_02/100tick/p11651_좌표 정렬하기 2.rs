// =======================================
//
// p11651 [좌표 정렬하기 2]
//
// [문제]
// 2차원 평면 위의 점 N개가 주어진다.
// 좌표를 y좌표가 증가하는 순으로,
// y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
// (-100,000 ≤ xi, yi ≤ 100,000)
// 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
//
// [출력]
// 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
//
// [https://www.acmicpc.net/problem/11651]
//
// =======================================
// IMPORT
// =======================================
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    // =======================================
    // INPUT(TRUNCATE N)
    // =======================================
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    input.clear();

    // =======================================
    // INPUT(xi, yi) * N
    // =======================================
    stdin().read_to_string(&mut input).unwrap();
    let mut points = input
        .trim_end()
        .split('\n')
        .map(|point| {
            point
                .split_whitespace()
                .flat_map(|v| v.parse())
                .collect::<Vec<i32>>()
        })
        .collect::<Vec<_>>();

    // =======================================
    // SORT
    // =======================================
    points.sort_by(|a, b| {
        // let x1 = a.get(0).unwrap();
        // let x2 = b.get(0).unwrap();
        let x1 = a[0];
        let x2 = b[0];

        // let y1 = a.get(1).unwrap();
        // let y2 = b.get(1).unwrap();
        let y1 = a[1];
        let y2 = b[1];

        if y1 == y2 {
            return x1.cmp(&x2);
        }
        y1.cmp(&y2)
    });

    // =======================================
    // WRITE TO OUTPUT
    // =======================================
    let mut output = String::new();
    for n in points {
        writeln!(output, "{} {}", n.get(0).unwrap(), n.get(1).unwrap()).unwrap();
    }

    // =======================================
    // OUTPUT
    // =======================================
    println!("{output}");
}
