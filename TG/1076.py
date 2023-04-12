def dfs(graph, start):
    visited = [False] * len(graph)
    stack = [start]
    count = 0

    while stack:
        v = stack.pop()
        if not visited[v]:
            visited[v] = True
            count += 1
            for neighbor in graph[v]:
                stack.append(neighbor)
    return count

t = int(input())

for i in range(t):
    n = int(input())
    start = int(input())
    graph = [[] for _ in range(n)]
    e = int(input())

    for j in range(e):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    print((dfs(graph, start) - 1) * 2)
