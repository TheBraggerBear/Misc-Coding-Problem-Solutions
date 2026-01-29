import sys
def switch(n):
    return 9 if n==2 else 2

for line in sys.stdin:
    target = int(line)
    counter = 2
    current = 1
    while current < target:
        counter = switch(counter)
        current *= counter
    if counter == 2:
        print("Ollie wins.")
    else:
        print("Stan wins.")