import java.util.*;

public class CandidateCode {
    static Graph graph;
    public static int minimumCost(String[] input1, int[] input2) {
        Road[] possibleRoads = GetAllPossibleRoads(input1, input2);
        createNewGraph(input1);
        int minimumNumberOfRoads = input1.length - 1;
        int minimumCost = 0;
        int k = 0;
        while (k < minimumNumberOfRoads) {
            Road roadToConstruct = FindCheapestNotConstructedRoad(possibleRoads, input1);
            minimumCost += roadToConstruct.constructionCost;
            k++;
            roadToConstruct.ConstructRoad();
            UpdateGraph(roadToConstruct);
            FindRoadsWhichDoNotNeedConstruction(possibleRoads);
        }

        return minimumCost;
    }

    private static void UpdateGraph(Road roadToConstruct) {
        Node[] nodes = graph.getNode();
        for(int i=0; i<nodes.length; i++)
        {
            for(int j=i+1; j<nodes.length; j++)
            {
                if(nodes[i]!=null&&nodes[j]!=null)
                if((nodes[i].getVertex().equalsIgnoreCase(roadToConstruct.city1)&&nodes[j].getVertex().equalsIgnoreCase(roadToConstruct.city2))||
                        (nodes[i].getVertex().equalsIgnoreCase(roadToConstruct.city2)&&nodes[j].getVertex().equalsIgnoreCase(roadToConstruct.city1)))
                {
                    nodes[i].addChildNode(nodes[j]);
                    nodes[j].addChildNode(nodes[i]);
                }
            }
        }
    }

    private static void FindRoadsWhichDoNotNeedConstruction(Road[] possibleRoads) {
        for (Node node : graph.getNode()) {
            graph.resetStateOfAllNodes();
            List<String> connectedCitiesToNode = GetConnectedCities(node);
            for (String city : connectedCitiesToNode) {
                for (Road possibleRoad : possibleRoads) {
                    if (!possibleRoad.constructed) {
                        if ((possibleRoad.city1.equalsIgnoreCase(city) && possibleRoad.city2.equalsIgnoreCase(node.getVertex())) || (possibleRoad.city2.equalsIgnoreCase(city) && possibleRoad.city1.equalsIgnoreCase(node.getVertex())))
                            possibleRoad.MarkAsNotNeeded();
                    }
                }
            }
        }
    }

    private static Road[] GetAllPossibleRoads(String[] input1, int[] input2) {
        Road[] possibleRoads = new Road[input2.length];
        int roadCount = 0;
        for (int i = 0; i < input1.length; i++) {
            for (int j = i + 1; j < input1.length; j++) {
                possibleRoads[roadCount] = new Road(input1[i], input1[j], input2[roadCount]);
                roadCount++;
            }
        }
        return possibleRoads;
    }

    private static Road FindCheapestNotConstructedRoad(Road[] possibleRoads, String[] allCities) {
        Road road = possibleRoads[0];
            for (Road possibleRoad : possibleRoads) {
                if (road.constructed || road.doNotNeedConstruction || (!possibleRoad.constructed && possibleRoad.constructionCost < road.constructionCost &&!possibleRoad.doNotNeedConstruction))
                    road = possibleRoad;
            }
        return road;
    }

    public static void createNewGraph(String[] cityNames)
    {
        graph = new Graph();
        Node[] temp = new Node[8];
        for (int i = 0; i < cityNames.length; i++)
        {
            temp[i] = new Node(cityNames[i],5);
            graph.addNode(temp[i]);
        }
    }

    private static List<String> GetConnectedCities(Node root)
    {
        List<String> connectedCities = new ArrayList<String>();
        //Avoid infinite loops
        if(root == null) return connectedCities;

        connectedCities.add(root.getVertex());
        root.state = State.Visited;

        //for every child
        for(Node n: root.getChild())
        {
            //if childs state is not visited then recurse
            if(n!=null && n.state == State.Unvisited)
            {
                connectedCities.addAll(GetConnectedCities(n));
            }
        }
        return connectedCities;
    }

    private static class Road {
        String city1;
        String city2;
        int constructionCost;
        private boolean constructed;
        private boolean doNotNeedConstruction;

        Road(String vertex1, String vertex2, int cost) {
            city1 = vertex1;
            city2 = vertex2;
            constructionCost = cost;
            constructed = false;
            doNotNeedConstruction = false;
        }

        public void ConstructRoad() {
            constructed = true;
        }

        public void MarkAsNotNeeded() {
            doNotNeedConstruction = true;
        }
    }

    private static class Graph {

        public int count; // num of vertices
        private Node vertices[];

        public Graph()
        {
            vertices = new Node[8];
            count = 0;
        }

        public void addNode(Node n)
        {
            if(count < 10)
            {
                vertices[count] = n;
                count++;
            }
        }

        public Node[] getNode()
        {
            return vertices;
        }

        public void resetStateOfAllNodes() {
            for (Node vertex : vertices) {
                if(vertex!=null)
                    vertex.state = State.Unvisited;
            }
        }
    }

    private static class Node {

        public Node[] child;
        public int childCount;
        private String vertex;
        public State state;

        public Node(String vertex, int childlen)
        {
            this.vertex = vertex;
            childCount = 0;
            child = new Node[childlen];
        }

        public void addChildNode(Node adj)
        {
            adj.state = State.Unvisited;
            if(childCount < 30)
            {
                this.child[childCount] = adj;
                childCount++;
            }
        }

        public Node[] getChild()
        {
            return child;
        }

        public String getVertex()
        {
            return vertex;
        }
    }

    private static enum State {
        Unvisited,Visited;
    }
}