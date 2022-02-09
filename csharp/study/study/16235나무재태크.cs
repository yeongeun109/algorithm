namespace study
{
    internal class _16235나무재태크
    {
        static void Main(string[] args)
        {
            int N, M, K;
            string[] str = Console.ReadLine().Split(" ");
            N = int.Parse(str[0]);
            M = int.Parse(str[1]);
            K = int.Parse(str[2]);

            int[,] food = new int[N, N];
            int[,] arr = new int[N, N];
            List<int>[,] tree3 = new List<int>[N, N];

            for(int i = 0; i < N; i++)
            {
                str = Console.ReadLine().Split(" ");
                for(int j = 0; j < N; j++)
                {
                    arr[i, j] = int.Parse(str[j]);
                    food[i, j] = 5;
                    tree3[i, j] = new List<int>();
                }
            }

            for(int i = 0; i < M; i++)
            {
                str = Console.ReadLine().Split(" ");
                tree3[int.Parse(str[0]) - 1, int.Parse(str[1]) - 1].Add(int.Parse(str[2]));
            }


            List<int[]> dead = new List<int[]>();
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for(int i = 0; i < K; i++)
            {
                // 봄
                for (int j = 0; j < N; j++)
                {
                    for (int k = 0; k < N; k++)
                    {
                        List<int> tmp = tree3[j, k];
                        tmp.Sort();
                        for (int l = 0; l < tmp.Count; l++)
                        {
                            if (food[j, k] >= tmp[l])
                            {
                                food[j, k] -= tmp[l];
                                tree3[j, k][l]++;
                            }
                            else
                            {
                                dead.Add(new int[] { j, k, tmp[l], l });
                            }
                        }
                    }
                }

                // 여름
                for(int j = dead.Count - 1; j >= 0; j--)
                {
                    food[dead[j][0], dead[j][1]] += (dead[j][2] / 2);
                    tree3[dead[j][0], dead[j][1]].RemoveAt(dead[j][3]);
                }
                dead.Clear();

                // 가을
                for(int j = 0; j < N; j++)
                {
                    for(int k = 0; k < N; k++)
                    {
                        List<int> tmp = tree3[j, k];
                        for (int l = 0; l < tmp.Count; l++)
                        {
                            if(tmp[l] % 5 == 0)
                            {
                                for (int m = 0; m < 8; m++)
                                {
                                    int tx = j + dx[m];
                                    int ty = k + dy[m];
                                    if (tx < 0 || tx >= N || ty < 0 || ty >= N)
                                        continue;

                                    tree3[tx, ty].Add(1);
                                }
                            }
                        }
                    }
                }

                // 겨울
                for(int j = 0; j < N; j++)
                {
                    for(int k = 0; k < N; k++)
                    {
                        food[j, k] += arr[j, k];
                    }
                }
            }


            int cnt = 0;
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    cnt += tree3[i, j].Count;
                }
            }

            Console.WriteLine(cnt);
        }
    }
}
