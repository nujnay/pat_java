package advanced1003;

import java.util.Stack;

/**
 * 邻接矩阵存储方式的Dijkstra算法
 *
 * @author wjgs
 */
public class Dijkstra {

    //通过下标映射元素值
    private int[] mapping;

    //图的二维数组
    private int[][] matrix;

    /**
     * 初始化图的顶点
     *
     * @param vertexes 顶点数组
     */
    public Dijkstra(int[] vertexes) {

        int length = vertexes.length;
        mapping = new int[length];
        matrix = new int[length][length]; //图的二维矩阵
        for (int i = 0; i < length; i++) {
            mapping[i] = vertexes[i];

        }


    }

    /**
     * 添加具有权值的边
     *
     * @param start
     * @param end
     * @param value
     */
    public void addEdge(int start, int end, int value) {
        int x = -1;
        int y = -1;

        //寻找坐标
        for (int i = 0; i < mapping.length; i++) {
            if (x != -1 && y != -1) {
                break;
            }
            if (start == mapping[i]) {
                x = i;
            }
            if (end == mapping[i]) {
                y = i;
            }
        }

        //判断顶点是否存在
        if (x == -1 || y == -1 || x > mapping.length - 1 || y > mapping.length - 1) {
            throw new IndexOutOfBoundsException("边的顶点不存在!");
        }

        //增加边的权值
        matrix[x][y] = value;

    }

    /**
     * Dijkstra算法实现到各点的最短路径
     *
     * @param start
     */

    public void dijkstra(int start) {
        int length = mapping.length;
        int x = -1;   //记录起始点
        for (int i = 0; i < length; i++) {
            if (mapping[i] == start) {
                x = i;
                break;
            }
        }
        if (x == -1) {
            throw new RuntimeException("未找到起始顶点");
        }

        //自动初始化为0，都属于未得到最短路径的顶点
        int[] s = new int[length];
        //存储v到u的最短距离
        int[][] distance = matrix;
        //存储x到u最短路径时u的前一个顶点
        int[] path = new int[length];

        //初始化path数组
        for (int i = 0; i < length; i++) {
            //如果可达就赋值
            if (matrix[x][i] > 0) {
                path[i] = x;
            } else {
                //不可达，则赋前一个顶点下标为-1
                path[i] = -1;
            }
        }

        //先把起始顶点加入s
        s[x] = 1;

        for (int i = 0; i < length; i++) {
            //首先需要寻找start顶点到各顶点最短的路径
            int min = Integer.MAX_VALUE;
            int v = 0;  //记录x到各顶点最短的
            for (int j = 0; j < length; j++) {
                if (s[j] != 1 && x != j && distance[x][j] != 0 && distance[x][j] < min) {
                    min = distance[x][j];
                    v = j;
                }
            }
            //v 是目前x到各顶点最短的
            s[v] = 1;
            //修正最短路径distance及最短距离path

            for (int j = 0; j < length; j++) {
                if (s[j] != 1 && distance[v][j] != 0 && (min + distance[v][j] < distance[x][j] || distance[x][j] == 0)) {
                    //说明加入了中间顶点之后找到了更短的路径
                    distance[x][j] = min + distance[v][j];
                    path[j] = v;

                }
            }

        }

        //打印最短路径值
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
            if (distance[x][i] != 0) {
                System.out.println(mapping[x] + "-->" + mapping[i] + "  最短路径长度:" + distance[x][i]);

                //path存储路径，可以逆序输出，可以借助栈实现正序输出
                System.out.print("逆序最短路径输出:");
                int index = i;
                while (index != -1) {
                    System.out.print(mapping[index] + " ");
                    stack.push(mapping[index]);
                    index = path[index];
                }
                System.out.print("正序最短路径输出:");
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println();
            }
        }


    }


    public static void main(String[] args) {
        int[] vetexes = {1, 2, 3, 4, 5, 6};
        Dijkstra graph = new Dijkstra(vetexes);
        graph.addEdge(1, 2, 16);
        graph.addEdge(2, 1, 16);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 5, 12);
        graph.addEdge(5, 1, 12);
        graph.addEdge(1, 6, 15);
        graph.addEdge(6, 1, 15);
        graph.addEdge(2, 4, 2);
        graph.addEdge(4, 2, 2);
        graph.addEdge(2, 6, 8);
        graph.addEdge(6, 2, 8);
        graph.addEdge(3, 5, 5);
        graph.addEdge(5, 3, 5);
        graph.addEdge(4, 6, 3);
        graph.addEdge(6, 4, 3);
        graph.addEdge(5, 6, 8);
        graph.addEdge(6, 5, 8);
        graph.addEdge(4, 5, 9);
        graph.addEdge(5, 4, 9);
        graph.dijkstra(1);

    }

}