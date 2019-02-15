
id = int(input())
print("id: {}".format(id))
first =  input().strip().split()
second = input().strip().split()
third = input().strip().split()
print(first)
print(second)
print(third)

upper = first[1]
left = second[0]
right = second[2] 
down = third[1]

if upper != '#':
    print("UP")
    
if left != '#':
    print("LEFT")

if right != '#':
    print("RIGHT")

if down != '#':
    print("DOWN")
