# define the dfs() function, which takes three parameters: graph, start, and visited. graph is a dictionary representing the graph, start is the starting vertex for DFS traversal, and visited is a set that keeps track of visited vertices. If visited is not provided, it is initialized as an empty set.
# If visited set is not provided, initialize it
# Mark the current vertex as visited
# Print the current vertex
# Iterate over unvisited neighbors of the current vertex
# Recursively call dfs() for each unvisited neighbor
    

def DFS(graph, start, visited = None):
    if visited is None:
        visited = set()

    visited.add(start)
    print(start, end = ' ')
    
    for neighbor in graph[start] - visited:
        DFS(graph, neighbor, visited)

# Example graph
graph = {
    'A': {'B', 'C'},
    'B': {'A', 'D', 'E'},
    'C': {'A', 'F'},
    'D': {'B'},
    'E': {'B', 'F'},
    'F': { 'E'}
}

print("\nDFS traversal:")
DFS(graph, 'A')




def DFS(graph, start):
    visited = set()
    stack = [start]  # Initialize stack with starting vertex

    while stack:  # Continue loop until stack is empty
        vertex = stack.pop()  # Pop vertex from top of stack
        if vertex not in visited:  # Check if vertex has not been visited
            print(vertex, end=' ')  # Print vertex
            visited.add(vertex)  # Mark vertex as visited

            # Push unvisited neighbors of vertex onto stack
            for neighbor in graph[vertex]:
                if neighbor not in visited:
                    stack.append(neighbor)

# Example graph
graph = {
    'A': {'B', 'C'},
    'B': {'A', 'D', 'E'},
    'C': {'A', 'F'},
    'D': {'B'},
    'E': {'B', 'F'},
    'F': {'C', 'E'}
}

print("\nDFS traversal:")
DFS(graph, 'A')
