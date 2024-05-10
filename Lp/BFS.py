# import deque to implement a FIFO queue efficiently.
# define the bfs() function, which takes two parameters: graph and start. graph is a dictionary representing the graph, and start is the starting vertex for BFS traversal.
# Set to keep track of visited vertices
# Initialize queue with starting vertex
# Continue loop until queue is empty
# Dequeue vertex from the front of the queue
# Check if the vertex has not been visited
# Print the vertex
# Mark the vertex as visited
# Enqueue unvisited neighbors of the vertex


from collections import deque

def BFS(graph, start):
    visited = set()
    queue = deque([start])

    while queue:
        vertex = queue.popleft()
        if vertex not in visited:
            print(vertex, end=" ")
            visited.add(vertex)
            queue.extend(graph[vertex] - visited)


graph = {
    'A': {'B', 'C'},
    'B': {'A', 'D', 'E'},
    'C': {'A', 'F'},
    'D': {'B'},
    'E': {'B', 'F'},
    'F': {'C', 'E'}
}

print("BFS Traveral")
BFS(graph, 'A')