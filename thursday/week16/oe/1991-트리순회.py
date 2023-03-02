import sys

n = int(sys.stdin.readline())
tree = {}

for _ in range(n):
    node, left, right = map(str, sys.stdin.readline().strip().split())
    tree[node] = left, right


def pre_order(v):
    if v != ".":
        print(v, end="")
        pre_order(tree[v][0])
        pre_order(tree[v][1])


def in_order(v):
    if v != ".":
        in_order(tree[v][0])
        print(v, end="")
        in_order(tree[v][1])


def post_order(v):
    if v != ".":
        post_order(tree[v][0])
        post_order(tree[v][1])
        print(v, end="")


root = "A"
pre_order(root)
print()
in_order(root)
print()
post_order(root)