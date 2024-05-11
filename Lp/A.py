import heapq

def heuristic(n1, n2, coordinates):
    # Retrieve coordinates from the dictionary
    x1, y1 = coordinates[n1]
    x2, y2 = coordinates[n2]
    # Calculate Manhattan distance
    return abs(x1 - x2) + abs(y1 - y2)

def a_star(graph, start, goal, coordinates):
    frontier = []
    heapq.heappush(frontier, (0, start))
    came_from = {}
    cost_so_far = {}
    came_from[start] = None
    cost_so_far[start] = 0

    while frontier:
        current_cost, current_node = heapq.heappop(frontier)

        if current_node == goal:
            break

        for next_node in graph[current_node]:
            new_cost = cost_so_far[current_node] + graph[current_node][next_node]
            if next_node not in cost_so_far or new_cost < cost_so_far[next_node]:
                cost_so_far[next_node] = new_cost
                priority = new_cost + heuristic(next_node, goal, coordinates)
                heapq.heappush(frontier, (priority, next_node))
                came_from[next_node] = current_node

    path = []
    current = goal
    while current != start:
        path.append(current)
        current = came_from[current]
    path.append(start)
    path.reverse()
    return path

# Example usage:
graph = {
    'A': {'B': 1, 'C': 4},
    'B': {'A': 1, 'D': 2},
    'C': {'A': 4, 'D': 5},
    'D': {'B': 2, 'C': 5}
}
coordinates = {'A': (0, 0), 'B': (1, 1), 'C': (2, 0), 'D': (1, 2)}
start_node = 'A'
goal_node = 'D'
path = a_star(graph, start_node, goal_node, coordinates)
print("Path:", path)