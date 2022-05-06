package graph;

import java.util.*;

public class ConstructGraph {
    public class Vertex {
        String label;

        public Vertex(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public class Graph {
        private Map<String, List<Vertex>> adjVertices = new HashMap<>();
        private Set<Vertex> listOfVertex = new HashSet<>();

        public Vertex getVertexByLabel(String label) {
            return listOfVertex.stream().filter(vertex -> {
                return vertex.label == label;
            }).findFirst().get();
        }

        public Vertex addVertex(String label) {
            Vertex v = new Vertex(label);
            this.getAdjVertices().putIfAbsent(label, new ArrayList<>());
            listOfVertex.add(v);
            return v;
        }

        public void removeVertex(Vertex vertex) {
            adjVertices.values().stream().forEach(list -> {
                list.remove(vertex);
            });
            adjVertices.remove(vertex);
        }

        public void addEdge(Vertex v1, Vertex v2) {
            this.getAdjVertices().get(v1.label).add(v2);
            this.getAdjVertices().get(v2.label).add(v1);
        }

        public void addDirectedEdge(Vertex v1, Vertex v2) {
            this.getAdjVertices().get(v1.getLabel()).add(v2);
        }


        public void removeEdge(Vertex v1, Vertex v2) {
            List<Vertex> listFromV1 = adjVertices.get(v1);
            List<Vertex> listFromV2 = adjVertices.get(v2);
            if (listFromV1 != null) listFromV1.remove(v2);
            if (listFromV2 != null) listFromV2.remove(v1);
        }

        public List<Vertex> getAdjVerticestmap(String label) {
            return adjVertices.get(label);
        }

        public Map<String, List<Vertex>> getAdjVertices() {
            return adjVertices;
        }


        public Set<Vertex> getListOfVertex() {
            return listOfVertex;
        }
    }

    public Graph createUndirectedGraph() {
        Graph graph = new Graph();
        Vertex a = graph.addVertex("a");
        Vertex b = graph.addVertex("b");
        Vertex c = graph.addVertex("c");
        Vertex d = graph.addVertex("d");
        Vertex e = graph.addVertex("e");
        Vertex f = graph.addVertex("f");
        Vertex g = graph.addVertex("g");
        Vertex h = graph.addVertex("h");
        Vertex i = graph.addVertex("i");
        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(a, d);
        graph.addEdge(b, e);
        graph.addEdge(d, h);
        graph.addEdge(e, c);
        graph.addEdge(c, h);
        graph.addEdge(c, f);
        graph.addEdge(c, g);
        graph.addEdge(h, g);
        graph.addEdge(f, i);
        graph.addEdge(f, e);
        graph.addEdge(g, i);


        return graph;
    }

    public Graph createDirectedGraph() {
        Graph graph = new Graph();
        Vertex a = graph.addVertex("a");
        Vertex b = graph.addVertex("b");
        Vertex c = graph.addVertex("c");
        Vertex d = graph.addVertex("d");
        Vertex e = graph.addVertex("e");
        Vertex f = graph.addVertex("f");
        Vertex g = graph.addVertex("g");
        Vertex h = graph.addVertex("h");
        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(a, c);
        graph.addDirectedEdge(b, d);
        graph.addDirectedEdge(c, b);
        graph.addDirectedEdge(c, f);
        graph.addDirectedEdge(d, e);
        graph.addDirectedEdge(d, f);
        graph.addDirectedEdge(f, b);
        graph.addDirectedEdge(g, e);
        graph.addDirectedEdge(g, h);
        graph.addDirectedEdge(h, g);


        return graph;
    }

    public void bfs(Vertex root, Graph graph) {
        Queue<Vertex> pendingQueue = new LinkedList();
        Map<String, Boolean> visitedMap = new HashMap<>();

        pendingQueue.add(root);
        while (!pendingQueue.isEmpty()) {
            Vertex current = pendingQueue.poll();
            visitedMap.put(current.label, true);
            graph.removeVertex(current);
            List<Vertex> candidates = graph.getAdjVerticestmap(current.label);
            if (candidates != null) {
                for (Vertex candidate : candidates) {
                    if (!visitedMap.getOrDefault(candidate.label, false) && !pendingQueue.contains(candidate)) {
                        pendingQueue.add(candidate);
                    }
                }
            }


            System.out.println("Explore vertex: " + current.label);
        }

    }

    public void dfsUtil(Vertex current, Map<String, Boolean> visitedMap, Graph graph) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                Vertex top = stack.pop();
                if (!visitedMap.containsKey(top.getLabel())) {
                    System.out.println(top.getLabel());
                    visitedMap.put(top.getLabel(), true);
                }
                List<Vertex> vertices = graph.getAdjVerticestmap(top.getLabel());
                if (vertices != null) {
                    for (Vertex v : vertices) {
                        if (!visitedMap.containsKey(v.getLabel())) {
                            stack.push(v);
                        }
                    }
                }
            }
        }
    }

    public void dfs(Vertex root, Graph graph) {
        Map<String, Boolean> visitedMap = new HashMap<>();
        dfsUtil(root, visitedMap, graph);

        Set<Vertex> listOfVertex = graph.getListOfVertex();
        listOfVertex.stream().forEach(v -> {
            if (!visitedMap.containsKey(v.getLabel())) {
                dfsUtil(v, visitedMap, graph);
            }
        });

    }


}
