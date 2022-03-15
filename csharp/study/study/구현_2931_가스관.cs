using System.Text;

namespace study
{
    internal class 구현_2931_가스관
    {
        static int R, C, pNum = 0;
        static char[][] map;
        static int[] dx = { 0, 1, 0, -1 };
        static int[] dy = { 1, 0, -1, 0 };
        static int[] M = new int[2], Z = new int[2];
        public class Pipe
        {
            int x;
            int y;
            char pipe;

            public Pipe(int tx, int ty, char tpipe)
            {
                x = tx;
                y = ty;
                pipe = tpipe;
            }

            public int X
            {
                get { return x; }
            }

            public int Y
            {
                get { return y; }
            }

            public char P
            {
                get { return pipe; }
            }
        }
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            R = int.Parse(str[0]);
            C = int.Parse(str[1]);
            map = new char[R][];

            for (int i = 0; i < R; i++)
            {
                string s = Console.ReadLine();
                map[i] = s.ToCharArray();
            }

            findLoc();

            Queue<Pipe> q = new Queue<Pipe>();
            bool[,] visited = new bool[R, C];
            q.Enqueue(new Pipe(M[0], M[1], ' '));
            visited[M[0], M[1]] = true;
            int resX = 0, resY = 0;
            char resC;
            string prePlus = ",";

            while (q.Count > 0)
            {
                Pipe tmp = q.Dequeue();
                int cx = tmp.X;
                int cy = tmp.Y;
                char cc = tmp.P;

                if (cx == Z[0] && cy == Z[1])
                {
                    resX = cx + 1;
                    resY = cy + 1;
                    resC = cc;
                    break;
                }

                if (cc != '+')
                {
                    for (int i = 0; i < 4; i++)
                    {
                        int tx = cx + dx[i];
                        int ty = cy + dy[i];

                        if (tx < 0 || tx >= R || ty < 0 || ty >= C || visited[tx, ty])
                            continue;
                        if (map[tx][ty] != '.')
                        {
                            if (map[tx][ty] == '|')
                            {
                                //if (cc != '1' && cc != '2' && cc != '3' && cc != '4')
                                //{ 
                                    if (cc == '|' && (i == 0 || i == 2))
                                        continue;
                                    q.Enqueue(new Pipe(tx, ty, '|'));
                                    visited[tx, ty] = true;
                                    if (i == 3)
                                        prePlus = "up";
                                    else if (i == 1)
                                        prePlus = "down";
                                //}
                            }
                            else if (map[tx][ty] == '-')
                            {
                                //if (cc != '1' && cc != '2' && cc != '3' && cc != '4')
                                //{
                                    if (cc == '-' && (i == 1 || i == 3))
                                        continue;
                                    q.Enqueue(new Pipe(tx, ty, '-'));
                                    visited[tx, ty] = true;
                                    if (i == 0)
                                        prePlus = "right";
                                    else if (i == 2)
                                        prePlus = "left";
                                //}
                            }
                            else if (map[tx][ty] == '+')
                            {
                                q.Enqueue(new Pipe(tx, ty, '+'));
                                visited[tx, ty] = true;
                                if(cc == '-')
                                {
                                    if (i == 0)
                                        prePlus = "right";
                                    else if(i == 2)
                                        prePlus = "left";
                                }else if(cc == '|')
                                {
                                    if (i == 1)
                                        prePlus = "down";
                                    else if (i == 3)
                                        prePlus = "up";
                                }else if(cc == '1')
                                    prePlus = "right";
                                else if(cc == '2')
                                    prePlus="up";
                                else if(cc == '3')
                                    prePlus = "up";
                                else if(cc == '4')
                                    prePlus = "down";
                            }
                            else if (map[tx][ty] == '1' && ((prePlus == "left" && i == 2) || (prePlus == "up" && i == 3)))
                            {
                                q.Enqueue(new Pipe(tx, ty, '1'));
                                visited[tx, ty] = true;
                                if (i == 2)
                                    prePlus = "down";
                                else if (i == 3)
                                    prePlus = "right";
                            }
                            else if (map[tx][ty] == '2' && ((prePlus == "left" && i == 2) || (prePlus == "down" && i == 1)))
                            {
                                q.Enqueue(new Pipe(tx, ty, '2'));
                                visited[tx, ty] = true;
                                if (i == 1)
                                    prePlus = "right";
                                else if (i == 2)
                                    prePlus = "up";
                            }
                            else if (map[tx][ty] == '3' && ((prePlus == "right" && i == 0) || (prePlus == "down" && i == 1)))
                            {
                                q.Enqueue(new Pipe(tx, ty, '3'));
                                visited[tx, ty] = true;
                                if (i == 0)
                                    prePlus = "up";
                                else if (i == 1)
                                    prePlus = "left";
                            }
                            else if (map[tx][ty] == '4' && ((prePlus == "right" && i == 0) || (prePlus == "up" && i == 3)))
                            {
                                q.Enqueue(new Pipe(tx, ty, '4'));
                                visited[tx, ty] = true;
                                if (i == 0)
                                    prePlus = "down";
                                else if (i == 3)
                                    prePlus = "left";
                            }
                        }
                        //else // 길 만들기
                        //{
                        //    q.Enqueue(new Pipe())
                        //}
                    }
                }
                else
                {
                    if(prePlus == "up" && cx - 1 >= 0)
                    {
                        q.Enqueue(new Pipe(cx - 1, cy, map[cx - 1][cy]));
                        visited[cx - 1, cy] = true;
                    }else if(prePlus == "down" && cx + 1 < R)
                    {
                        q.Enqueue(new Pipe(cx + 1, cy, map[cx +  1][cy]));
                        visited[cx + 1, cy] = true;
                    }
                    else if(prePlus == "left" && cy - 1 >= 0)
                    {
                        q.Enqueue(new Pipe(cx, cy - 1, map[cx][cy - 1]));
                        visited[cx, cy - 1] = true;
                    }
                    else
                    {
                        if (cy + 1 < C)
                        {
                            q.Enqueue(new Pipe(cx, cy + 1, map[cx][cy + 1]));
                            visited[cx, cy + 1] = true;
                        }
                    }
                }
            }

            Console.WriteLine(resX + " " + resY);
        }

        static void findLoc()
        {
            for (int i = 0; i < R; i++)
            {
                for (int j = 0; j < C; j++)
                {
                    if (map[i][j] != '.')
                        pNum++;
                    if (map[i][j] == 'M')
                    {
                        M[0] = i;
                        M[1] = j;
                    }
                    else if (map[i][j] == 'Z')
                    {
                        Z[0] = i;
                        Z[1] = j;
                    }
                }
            }
        }
    }
}
/*
if (i == 0) // 좌에서 우로
{

}
else if (i == 1) // 위에서 아래로
{

}
else if (i == 2) // 우에서 좌로
{

}
else // 아래에서 위로
{

}
*/