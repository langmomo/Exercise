package Graph;

public class UnionFind {
    //union find----use for find group
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public void findComponent(int[][] grid){
        int x = grid.length;
        int y = grid[0].length;
        int[] items = new int[x*y];
        //initial
        for(int i=0; i<items.length; i++){
            items[i] = i;
        }
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                int p = i*y+j;
                if(grid[i][j]==1){

                    for(int k=0; k<4; k++){
                        int newx = i+dir[k][0];
                        int newy = j+dir[k][1];
                        if(newx>=0 && newy>=0 && newx<x && newy<y && grid[newx][newy]==1){
                            union(newx*y+newy, p, items);
                        }
                    }
                }
                else{
                    items[p] = -1;
                }
            }
        }
        int count = 0;
        for(int i=0; i<items.length; i++){
            if(items[i] ==i){
                count++;
            }
        }
        System.out.println(count);
    }

    public void union(int x, int y, int[] items){
        x = find(x, items);
        y = find(y, items);
        if(x != y) {
            items[x] = y;
        }
    }

    public int find(int x,  int[] items){
        if(items[x]!=x){
            x = find(items[x], items);
        }
        return x;

    }
    public static void main(String[] args){
        int[][] grid = {{1,1,0,0,0},
                        {1,0,0,0,0},
                        {0,0,0,0,1},
                        {0,0,0,1,1}};
        UnionFind u = new UnionFind();
        u.findComponent(grid);

    }
}
