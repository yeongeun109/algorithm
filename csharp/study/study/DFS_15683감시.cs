namespace HelloWorld
{
    class Program
    {
        static int res, a, b;
        static List<int[]> list = new List<int[]>();
        static int[,] map, tmp2;

        static void Main(string[] args)
        {
            string? str = Console.ReadLine();
            a = Convert.ToInt32(str.Split(" ")[0]);
            b = Convert.ToInt32(str.Split(" ")[1]);
            res = a * b;
            map = new int[a, b];

            for (int i = 0; i < a; i++)
            {
                str = Console.ReadLine();
                string[] tmp = str.Split(" ");
                for (int j = 0; j < b; j++)
                {
                    map[i, j] = Convert.ToInt32(tmp[j]);
                    if (map[i, j] != 0)
                    {
                        list.Add(new int[] { i, j, map[i, j] });
                    }
                }
            }

            if (list.Count != 0)
                dfs(map, 0);

            Console.WriteLine(res);
        }

        static void up(int cx, int cy)
        {
            for (int i = cx - 1; i >= 0; i--)
            {
                if (tmp2[i, cy] == 6)
                    break;
                else if (tmp2[i, cy] == 0)
                    tmp2[i, cy] = -1;
            }
        }
        static void down(int cx, int cy)
        {
            for (int i = cx + 1; i < a; i++)
            {
                if (tmp2[i, cy] == 6)
                    break;
                else if (tmp2[i, cy] == 0)
                    tmp2[i, cy] = -1;
            }
        }
        static void left(int cx, int cy)
        {
            for (int i = cy - 1; i >= 0; i--)
            {
                if (tmp2[cx, i] == 6)
                    break;
                else if (tmp2[cx, i] == 0)
                    tmp2[cx, i] = -1;
            }
        }
        static void right(int cx, int cy)
        {
            for (int i = cy + 1; i < b; i++)
            {
                if (tmp2[cx, i] == 6)
                    break;
                else if (tmp2[cx, i] == 0)
                    tmp2[cx, i] = -1;
            }
        }
        static void dfs(int[,] before, int cnt)
        {
            if (cnt == list.Count)
            {
                int zeroCnt = 0;
                for (int i = 0; i < a; i++)
                {
                    for (int j = 0; j < b; j++)
                    {
                        if (before[i, j] == 0)
                            zeroCnt++;
                    }
                }
                res = Math.Min(res, zeroCnt);
                return;
            }

            int[] tmp = list.ElementAt<int[]>(cnt);
            int cx = tmp[0];
            int cy = tmp[1];
            tmp2 = (int[,])before.Clone();

            if (tmp[2] == 1)
            {
                // 상
                up(cx, cy);
                dfs(tmp2, cnt + 1);

                // 하
                tmp2 = (int[,])before.Clone();
                down(cx, cy);
                dfs(tmp2, cnt + 1);

                // 좌
                tmp2 = (int[,])before.Clone();
                left(cx, cy);
                dfs(tmp2, cnt + 1);

                // 우
                tmp2 = (int[,])before.Clone();
                right(cx, cy);
                dfs(tmp2, cnt + 1);
            }
            else if (tmp[2] == 2)
            {
                // 상하
                up(cx, cy);
                down(cx, cy);
                dfs(tmp2, cnt + 1);

                // 좌우
                tmp2 = (int[,])before.Clone();
                left(cx, cy);
                right(cx, cy);
                dfs(tmp2, cnt + 1);
            }
            else if (tmp[2] == 3)
            {
                // 위오
                up(cx, cy);
                right(cx, cy);
                dfs(tmp2, cnt + 1);

                // 오아
                tmp2 = (int[,])before.Clone();
                right(cx, cy);
                down(cx, cy);
                dfs(tmp2, cnt + 1);

                // 아왼
                tmp2 = (int[,])before.Clone();
                down(cx, cy);
                left(cx, cy);
                dfs(tmp2, cnt + 1);

                // 왼위
                tmp2 = (int[,])before.Clone();
                left(cx, cy);
                up(cx, cy);
                dfs(tmp2, cnt + 1);
            }
            else if (tmp[2] == 4)
            {
                // 왼위오
                left(cx, cy);
                up(cx, cy);
                right(cx, cy);
                dfs(tmp2, cnt + 1);

                // 위오아
                tmp2 = (int[,])before.Clone();
                up(cx, cy);
                right(cx, cy);
                down(cx, cy);
                dfs(tmp2, cnt + 1);

                // 오아왼
                tmp2 = (int[,])before.Clone();
                right(cx, cy);
                down(cx, cy);
                left(cx, cy);
                dfs(tmp2, cnt + 1);

                // 아왼위
                tmp2 = (int[,])before.Clone();
                down(cx, cy);
                left(cx, cy);
                up(cx, cy);
                dfs(tmp2, cnt + 1);
            }
            else if (tmp[2] == 5)
            {
                down(cx, cy);
                left(cx, cy);
                up(cx, cy);
                right(cx, cy);
                dfs(tmp2, cnt + 1);
            }
            else
            {
                dfs(tmp2, cnt + 1);
            }
        }

    }
}