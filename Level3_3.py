def solution(n):
    x = int(n)
    c = 0
    
    while x > 1:
        if x & 1 == 1:
            # x is odd
            if x % 4 == 1 or x==3:
                x -= 1
            else:
                x += 1
        else:
            # x is even
            x = x >> 1
        c += 1
    return c
