namespace study
{
    internal class BFS_16985_Maaaaaaaaaaze
    {
        static int[,,] maze = new int[5, 5, 5];
        static List<int[,]> plates = new List<int[,]>();
        static int res = int.MaxValue;
        
        static void Main(string[] args)
        {
            for(int i = 0; i < 5; i++)
            {
                int[,] tmp = new int[5, 5];
                for(int j = 0; j < 5; j++)
                {
                    string[] str = Console.ReadLine().Split(' ');
                    for(int k = 0; k < 5; k++)
                    {
                        tmp[j, k] = int.Parse(str[k]);
                    }
                }
                
                plates.Add(tmp);
            }

            comb2(0);
            
            Console.WriteLine(res);
        }

        static void turn(int x)
        {
            int[,] tmp = new int[5, 5];

            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    tmp[j, (5 - 1) - i] = plates[x][i, j];
                }
            }
            
            plates[x] = (int[,])tmp.Clone();
            comb(0);
        }

        static bool[] selected = new bool[5];
        static bool[] selected2 = new bool[5];
        static int[] nums = new int[5];
        static int[] nums2 = new int[5];
        static int[] dx = { 0, 1, 0, -1, 0, 0 };
        static int[] dy = { 1, 0, -1, 0, 0, 0 };
        static int[] dz = { 0, 0, 0, 0, -1, 1 };
        static void comb(int cnt)
        {
            if(cnt == 5)
            {
                BFS();
                return;
            }

            for(int i = 0; i < 5; i++)
            {
                if (!selected[i])
                {
                    selected[i] = true;
                    nums[cnt] = i;
                    comb(cnt + 1);
                    selected[i] = false;
                }
            }
        }

        static void comb2(int cnt)
        {
            if (cnt == 5)
            {
                for(int i = 0; i < 5; i++)
                {
                    for(int j = 0; j < nums2[i]; j++)
                    {
                        turn(i);
                    }
                }
                return;
            }

            for (int i = 0; i < 4; i++)
            {
                nums2[cnt] = i;
                comb2(cnt + 1);
            }
        }

        static void BFS()
        {
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    for(int k = 0; k < 5; k++)
                    {
                        maze[i, j, k] = plates[i][j, k];
                    }
                }
            }

            Queue<int[]> q = new Queue<int[]>();
            bool[,,] visited = new bool[5, 5, 5];
            q.Enqueue(new int[] { 0, 0, 0 });
            visited[0, 0, 0] = true;
            int cnt = 0;
            bool success = false;
            while(q.Count > 0)
            {
                int[] tmp = q.Dequeue();
                int cx = tmp[0];
                int cy = tmp[1];
                int cz = tmp[2];
                cnt++;

                if (cx == 4 && cy == 4 && cz == 4)
                {
                    success = true;
                    break;
                }

                for(int i = 0; i < 6; i++)
                {
                    int tx = cx + dx[i];
                    int ty = cy + dy[i];
                    int tz = cz + dz[i];

                    if (tx < 0 || tx >= 5 || ty < 0 || ty >= 5 || tz < 0 || tz >= 5 || visited[tz, tx, ty])
                        continue;

                    if (maze[tz, tx, ty] == 0)
                        continue;
                    q.Enqueue(new int[] { tx, ty, tz });
                    visited[tz, tx, ty] = true;
                }
            }

            if (success)
                res = Math.Min(res, cnt);
        }
    }
}
