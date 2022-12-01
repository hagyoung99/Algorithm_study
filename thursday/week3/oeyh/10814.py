import sys
n = int(sys.stdin.readline())

array = [] 
for i in range(n):
    lists = sys.stdin.readline().split()
    array.append((int(lists[0]), lists[1])) 

def setting(array): 
    return array[0] 

array.sort(key=setting) 

for k in range(n): 
    print(array[k][0], array[k][1]) 