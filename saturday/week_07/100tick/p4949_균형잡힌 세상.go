package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	scanner = bufio.NewScanner(os.Stdin)
	texts   []string
)

func main() {
	for {
		scanner.Scan()
		text := scanner.Text()
		if text == "." {
			break
		}
		texts = append(texts, text)
	}

	for _, text := range texts {
		if IsBalancedText(text) {
			fmt.Println("yes")
		} else {
			fmt.Println("no")
		}
	}
}

func IsBalancedText(text string) bool {
	parens := Stack{data: []rune{}}

	for _, t := range text {
		if t == '(' || t == '[' {
			parens.Push(t)
		}
		if t == ')' {
			if parens.Empty() || parens.Top() != '(' {
				return false
			}
			parens.Pop()
		}
		if t == ']' {
			if parens.Empty() || parens.Top() != '[' {
				return false
			}
			parens.Pop()
		}
	}

	return parens.Empty()
}

type Stack struct {
	data []rune
}

func (s *Stack) Push(r rune) {
	s.data = append(s.data, r)
}

func (s *Stack) Empty() bool {
	return len(s.data) == 0
}

func (s *Stack) Top() rune {
	if !s.Empty() {
		return s.data[len(s.data)-1]
	}
	return 0
}

func (s *Stack) Pop() {
	if !s.Empty() {
		s.data = s.data[:len(s.data)-1]
	}
}
