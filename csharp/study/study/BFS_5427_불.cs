namespace study
{
    internal class BFS_5427_불
    {
        static int[] dx = { 0, 1, 0, -1 };
        static int[] dy = { 1, 0, -1, 0 };
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            for(int t = 0; t < T; t++)
            {
                string[] str = Console.ReadLine().Split(' ');
                int h = int.Parse(str[0]);
                int w = int.Parse(str[1]);
                char[,] map = new char[w,h];
                int sx = 0, sy = 0;
                List<int[]> fire = new List<int[]>();

                for(int i = 0; i < w; i++)
                {
                    string? v = Console.ReadLine();
                    for(int j = 0; j < h; j++)
                    {
                        map[i, j] = v[j];
                        if(map[i, j] == '@')
                        {
                            sx = i;
                            sy = j;
                        }else if(map[i, j] == '*')
                        {
                            fire.Add(new int[] { i, j });
                        }
                    }
                }

                Queue<int[]> fq = new Queue<int[]>();
                bool[,] fvisited = new bool[w, h];
                for(int i = 0; i < fire.Count; i++)
                {
                    fq.Enqueue(fire[i]);
                    fvisited[fire[i][0], fire[i][1]] = true;
                }

                Queue<int[]> sq = new Queue<int[]>();
                bool[,] svisited = new bool[w, h];
                sq.Enqueue(new int[] { sx, sy });
                svisited[sx, sy] = true;

                int cnt = 0;
                bool flag = false;

                while (sq.Count > 0)
                {
                    int fsize = fq.Count, ssize = sq.Count;
                    cnt++;
                    for (int j = 0; j < fsize; j++)
                    {
                        int[] tmp = fq.Dequeue();
                        int cx = tmp[0];
                        int cy = tmp[1];

                        for (int i = 0; i < 4; i++)
                        {
                            int tx = cx + dx[i];
                            int ty = cy + dy[i];

                            if (tx < 0 || tx >= w || ty < 0 || ty >= h || map[tx, ty] == '#' || fvisited[tx, ty])
                                continue;

                            fvisited[tx, ty] = true;
                            fq.Enqueue(new int[] { tx, ty });
                            map[tx, ty] = '*';
                        }
                    }
                    

                    for (int j = 0; j < ssize; j++)
                    {
                        int[] tmp = sq.Dequeue();
                        int cx = tmp[0];
                        int cy = tmp[1];
                        for (int i = 0; i < 4; i++)
                        {
                            int tx = cx + dx[i];
                            int ty = cy + dy[i];

                            if (tx < 0 || tx >= w || ty < 0 || ty >= h)
                            {
                                flag = true;
                                break;
                            }
                            if (map[tx, ty] == '#' || map[tx, ty] == '*' || svisited[tx, ty])
                                continue;

                            svisited[tx, ty] = true;
                            sq.Enqueue(new int[] { tx, ty });
                        }
                        if (flag)
                            break;
                    }

                    if (flag)
                        break;
                }

                if (flag)
                    Console.WriteLine(cnt);
                else
                    Console.WriteLine("IMPOSSIBLE");
            }
        }
    }
}