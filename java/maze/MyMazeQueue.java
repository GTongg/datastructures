
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author user
 */
public class MyMazeQueue {
    static Point start, end;
    static int row, col;
    static Point dirs[];
    public static void main(String[] args) {
        try {
            File file = new File("mazedata2.txt");
            Scanner scan = new Scanner(file);
//            String line = scan.nextLine();
//            String str[]= line.split(" ");
            row = scan.nextInt();
            col = scan.nextInt();
//            System.out.printf("row=%d, col=%d\n", row, col);
            int [][] maze = new int[row][col];
            readMaze(scan, maze);
            start= setPoint(maze, "�_�l");
            end= setPoint(maze, "����");
            showMaze(maze);
            if (findPath(maze)) {
                showMaze(maze);
                showPath(maze);
            }
            else
                System.out.println("�䤣��i�檺���|.");
        } catch (FileNotFoundException ex) {
            System.out.printf("error in opening file: %s\n", ex.getMessage());
        }
        
    }

    private static void readMaze(Scanner scan, int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = scan.nextInt();                
            }            
        }        
    }

    private static void showMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
//                System.out.print(maze[i][j]+" ");
                switch (maze[i][j])
                {                    
                    case 0: if (start.x==i && start.y==j) 
                               System.out.print("��");
                            else if (end.x==i && end.y==j) 
                                System.out.print("��");
                            else
                                System.out.print("�@");
                            break;
                    case 1: System.out.print("�D");
                            break;
                    case 2: System.out.print("��");
                            break;
                    case 3: System.out.print("��");//��������
                            break;
                    case 4: System.out.print("��");
                            break;
                    case 5: System.out.print("��");
                            break;
                    case 6: System.out.print("��");
                            break;
                    case 7: System.out.print("��");
                            break;
                    case 8: System.out.print("��");
                            break;
                    case 9: System.out.print("��");
                            break;
                    default: System.out.print(maze[i][j]);
                            break;
                    
                }
            }            
            System.out.println();
        } 
    }

    private static Point setPoint(int[][] maze, String msg) {
        Scanner scan = new Scanner(System.in);
        int r, c;
        while (true) {
            System.out.printf("�п�J%s�I�y��: ", msg);
            r = scan.nextInt();
            c = scan.nextInt();
            if (maze[r][c] == 0) break;
        }
        
//        maze[r][c] = -1;
        return new Point(r, c);
        
    }

    public static void showPath(int [][] maze) {
        // for (int i = 0; i < row; i++) {
        //     for (int j = 0; j < col; j++) {
        //         System.out.printf("%2d ", maze[i][j]);
        //     }
        //     System.out.println();
        // }

        // 3->4->5 ������=5-3=2
        int path_length = maze[end.x][end.y] - 3;
        Point[] path = new Point[path_length];
        Point here = end, nbr = null;
        for (int i = path_length - 1; i >= 0; i--) {
            path[i] = here;
            for (int j = 0; j < dirs.length; j++) {
                nbr = new Point(here.x + dirs[j].x, here.y + dirs[j].y);
                if (nbr.x > 0 && nbr.x < row && nbr.y > 0 && nbr.y < col
                && maze[nbr.x][nbr.y] == i + 3) {
                    break;
                }
            }
            here = nbr;
        }

        System.out.printf("[%d, %d] ", start.x, start.y);
        for (Point point : path) {
            System.out.printf("[%d, %d] ", point.x, point.y);
        }
    }
    // Here we write a Maze class that have methods to initialize the map (read from file)
    // and showMap(), setStart(), setEnd(), showPath(), and findPath()
    // where setStart, setEnd, and findPath are of type boolean
    public static boolean findPath(int [][] maze) {      
        int total_dirs = 4;
        dirs = new Point[total_dirs]; // ��V
        for (int i = 0; i < total_dirs; i++) {
            dirs[i] = new Point();
        }
        // note: ���B�� x �������Orow, �� y �������O col
        dirs[0].x = 0;        dirs[0].y = 1; // �k
        dirs[1].x = 1;        dirs[1].y = 0; // �U 
        dirs[2].x = 0;        dirs[2].y = -1; // ��
        dirs[3].x = -1;       dirs[3].y = 0;  // �W
        
        Point here = start, nbr = null;
        Queue< Point > Q = new LinkedList< Point >();

        // �ϥ� breadth-first search �s���u���`�M, �N�_�l�I�]��3, �U�@�B�]���ثe��m����
        // �[1, �H������... ����stack����, queue�����|�ߨ貾�ܤU�@�B, �|�N�Ҧ��i�檺�B
        // �s�� queue. 
        maze[here.x][here.y] = 3;
        do {
            for (int i = 0; i < dirs.length; i++) {
                nbr = new Point(here.x + dirs[i].x, here.y + dirs[i].y);
                if (nbr.x < 0 || nbr.x >= row || nbr.y < 0 || nbr.y >= col) {
                    continue;
                }
                if (maze[nbr.x][nbr.y] == 0) {
                    maze[nbr.x][nbr.y] = maze[here.x][here.y] + 1;
                    Q.add(nbr);
                }
                if (nbr.equals(end)) {
                    break; // done
                }
            }
            if (nbr.equals(end)) {
                break; // done
            }
            if (Q.isEmpty()) {
                return false;
            }
            here = Q.remove();
        } while (true);
        
        return true;        
    }        
}