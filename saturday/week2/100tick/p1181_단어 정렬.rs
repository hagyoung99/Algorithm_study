// =======================================
//
// p1181 [단어 정렬]
//
// [문제]
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면
// 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2. 길이가 같으면 사전 순으로
//
// [입력]
// 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
// 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
// 주어지는 문자열의 길이는 50을 넘지 않는다.
//
// [출력]
// 조건에 따라 정렬하여 단어들을 출력한다.
// 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
//
// [https://www.acmicpc.net/problem/1181]
//
// =======================================
// IMPORT
// =======================================
use std::cmp::Ordering;
use std::collections::HashSet;
use std::fmt::Write;
use std::hash::Hash;
use std::io::{stdin, Read};

fn main() {
    // =======================================
    // INPUT(TRUNCATE N)
    // =======================================
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut words = input
        .split_ascii_whitespace()
        .skip(1)
        .map(|v| v)
        .collect::<Vec<&str>>();

    // remove duplicate words with HashSet
    deduplicate(&mut words);
    // =======================================
    // SORT
    // =======================================
    words.sort_by(|a, b| {
        if a.len() == b.len() {
            return a.cmp(b);
        }
        if a.len() < b.len() {
            return Ordering::Less;
        }
        Ordering::Greater
    });

    // =======================================
    // CREATE deduplicate fn for uniqueness
    // =======================================
    fn deduplicate<T: Eq + Hash + Copy>(v: &mut Vec<T>) {
        let mut hs = HashSet::new();
        // IF TRY TO PUT DUPLICATE KEYS, hs.insert() will return `false`
        // by `retain()`, duplicate keys removed from the Vec left only 1 unique key
        v.retain(|e| hs.insert(*e));
    }

    // =======================================
    // WRITE TO OUTPUT
    // =======================================
    let mut output = String::new();
    for w in words {
        writeln!(output, "{}", w).unwrap();
    }

    // =======================================
    // OUTPUT
    // =======================================
    println!("{output}");
}
