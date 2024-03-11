N = int(input())

for _ in range(N):
    words = input().split()
    for word in words:
        for i in range(len(word) - 1, -1, -1):
            print(word[i], end='')
        print(' ', end = '')
    print()
