package main

import (
	"fmt"
)

type WeightHeight struct {
	weight, height int
}

var (
	n     int
	whs   []WeightHeight
	ranks []int
)

func main() {
	fmt.Scanf("%d", &n)
	ranks = make([]int, n)
	for i := 0; i < n; i++ {
		var w, h int
		fmt.Scanf("%d %d", &w, &h)

		whs = append(whs, WeightHeight{
			weight: w,
			height: h,
		})
	}

	for i, wh1 := range whs {
		rank := len(whs)
		for j, wh2 := range whs {
			if i == j {
				continue
			}
			if wh1.height < wh2.height && wh1.weight < wh2.weight {
				continue
			} else {
				rank--
			}
		}
		ranks[i] = rank
	}

	var output string
	for _, r := range ranks {
		output += fmt.Sprintf("%d ", r)
	}
	fmt.Println(output)
}
