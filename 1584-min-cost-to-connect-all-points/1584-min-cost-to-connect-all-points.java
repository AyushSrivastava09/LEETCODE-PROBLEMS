class Solution {
    class Edge implements Comparable<Edge> {
        int src[];
        int dst[];
        int wt;
        Edge(int src[],int dst[]){
            this.src = src;
            this.dst = dst;
            wt = Math.abs(src[0]-dst[0]) + Math.abs(src[1]-dst[1]);
        }
        @Override
        public int compareTo(Edge e){
            return this.wt - e.wt;
        }
    }
    void init(int [][] pts,ArrayList<Edge> graph[],Map<int[],Integer> map){
        int n = pts.length;
        for(int i = 0;i < n; i++){
            graph[i] = new ArrayList<Edge>();
            for(int  j = 0;j < n; j++){
                if(i != j){
                    graph[i].add(new Edge(pts[i],pts[j]));
                }
            }
        }
        for(int i = 0;i < n; i++){
            map.put(pts[i],i);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<Edge> graph[] = new ArrayList[n];
        Map<int[],Integer> map = new HashMap<>();
        
        init(points,graph,map);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.offer(new Edge(points[0],points[0]));
        Map<int[],Boolean> vis = new HashMap<>();
        int min = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!vis.getOrDefault(curr.dst,false)){
                min += curr.wt;
                vis.put(curr.dst,true);
                int idx = map.get(curr.dst);
                for(int j = 0;j < graph[idx].size(); j++){
                    Edge e = graph[idx].get(j);
                    pq.offer(new Edge(e.src,e.dst));
                }
            }
        }
        return min;    
    }
}