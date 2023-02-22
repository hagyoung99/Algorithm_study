// =======================================
//
// p2108 [통계학]
//
// [문제]
// 수를 처리하는 것은 통계학에서 상당히 중요한 일이다.
// 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다.
// 단, N은 홀수라고 가정하자.
// 산술평균 : N개의 수들의 합을 N으로 나눈 값
// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
// N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
// 단, N은 홀수이다.
// 그 다음 N개의 줄에는 정수들이 주어진다.
// 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
//
// [출력]
// 첫째 줄에는 산술평균을 출력한다.
// 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
// 둘째 줄에는 중앙값을 출력한다.
// 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
// 넷째 줄에는 범위를 출력한다.

use std::{
    collections::{BTreeMap, HashMap},
    hash::Hash,
    io::Read,
    ops::Add,
};

// [https://www.acmicpc.net/problem/2108]
//
// =======================================
// IMPORT
// =======================================
fn main() {
    let mut buf = String::new();
    std::io::stdin().read_to_string(&mut buf).unwrap();

    let mut nums = buf
        .split_ascii_whitespace()
        .skip(1)
        .flat_map(|c| c.parse())
        .collect::<Vec<i32>>();

    // 1. avg
    let sum: i32 = nums.iter().sum();
    let avg = (sum as f64 / nums.len() as f64).round() as i32;

    // Sort
    nums.sort();
    // 2. median
    let median = nums[nums.len() / 2];
    // 3. mode
    // using HashMap

    let mut modes: Vec<(i32, i32)> = Vec::new();
    let mut map: HashMap<i32, i32> = HashMap::new();
    for n in nums.iter() {
        if !map.contains_key(&n) {
            map.insert(*n, 1);
        } else {
            *map.get_mut(&n).unwrap() += 1;
        }
    }

    for n in map.keys() {
        modes.push((*n, map[n]));
    }

    modes.sort_by(|a, b| {
        // .0 -> num
        // .1 -> cnt
        if a.1 == b.1 {
            return a.0.cmp(&b.0);
        }
        b.1.cmp(&a.1)
    });
    let mode = if modes.len() == 1 || modes[0].1 != modes[1].1 {
        modes[0].0
    } else {
        modes[1].0
    };

    // 4. rng(range)
    let rng = nums.last().unwrap() - nums.first().unwrap();
    println!("{avg}");
    println!("{median}");
    println!("{mode}");
    println!("{rng}");
}
