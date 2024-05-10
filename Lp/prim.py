from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, u, v, weight):
        self.graph[u].append((v, weight))
        self.graph[v].append((u, weight))

    def prim_mst(self):
        visited = set()
        mst = []

        start_vertex = next(iter(self.graph))
        visited.add(start_vertex)

        while len(visited) < len(self.graph):
            min_edge = min((u, v, w) for u in visited for v, w in self.graph[u] if v not in visited)
            mst.append(min_edge)
            visited.add(min_edge[1])

        return mst

# Example usage
g = Graph()
g.add_edge('A', 'B', 2)
g.add_edge('A', 'C', 3)
g.add_edge('B', 'C', 1)
g.add_edge('B', 'D', 1)
g.add_edge('C', 'D', 2)

mst = g.prim_mst()
print("Edges in the Minimum Spanning Tree:")
for edge in mst:
    print(edge)
