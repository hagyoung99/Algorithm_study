// =======================================
//
// p1427 [소트 인사이드]
//
// [문제]
// 배열을 정렬하는 것은 쉽다.
// 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
//
// [입력]
// 첫째 줄에 정렬하려고 하는 수 N이 주어진다.
// N은 1,000,000,000보다 작거나 같은 자연수이다.
//
// [출력]
// 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
//
// [https://www.acmicpc.net/problem/1427]
//
// =======================================
// IMPORT
// =======================================
fn main() {
    let mut buf = String::new();
    std::io::stdin().read_line(&mut buf).unwrap();

    // String -> Vec<char> -> Sort -> String -> Write to Stdout
    let mut chars = buf.chars().collect::<Vec<char>>();
    chars.sort_by(|a, b| b.cmp(a));

    let w = chars.iter().collect::<String>();
    print!("{w}");
}
