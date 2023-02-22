use std::{collections::VecDeque, fmt::Write};

fn main() {
    let mut buf = String::new();
    let input = read_line_as_vec_i32(&mut buf);
    let n = input[0] as usize;
    let k = input[1] as usize;

    let mut nums = (1..=n).collect::<VecDeque<_>>();
    let mut ans: VecDeque<usize> = VecDeque::new();

    for _ in 0..n {
        for _ in 0..(k - 1) {
            let f = nums.pop_front().unwrap();
            nums.push_back(f);
        }
        ans.push_back(nums.pop_front().unwrap());
    }

    let mut output = String::new();
    for n in ans {
        write!(output, "{}, ", n).unwrap();
    }

    output.remove(output.len() - 1);
    output.remove(output.len() - 1);
    print!("<{output}>");
}

fn read_line_as_vec_i32(buf: &mut String) -> Vec<i32> {
    buf.clear();
    std::io::stdin().read_line(buf).unwrap();
    buf.trim()
        .split_whitespace()
        .flat_map(|s| s.parse())
        .collect()
}
