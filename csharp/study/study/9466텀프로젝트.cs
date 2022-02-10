namespace study
{
    internal class _9466텀프로젝트
    {
        static int n, cnt = 0;
        static int[] choseNum;
        static bool[] visited, done;

        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            for(int t = 0; t < T; t++)
            {
                cnt = 0;
                n = int.Parse(Console.ReadLine());
                choseNum = new int[n];
                visited = new bool[n];
                done = new bool[n];
                string[] str = Console.ReadLine().Split(" ");
                for(int i = 0; i < n; i++)
                {
                    choseNum[i] = int.Parse(str[i]) - 1;
                }

                for(int i = 0; i < n; i++)
                {
                    if (!visited[i])
                        DFS(i);
                }
                Console.WriteLine(n - cnt);
            }
        }

        static void DFS(int now)
        {
            visited[now] = true;

            int next = choseNum[now];
            if(!visited[next])
                DFS(next);
            else if (!done[next]) // 사이클
            {
                for(int i = next; i != now; i = choseNum[i])
                {
                    cnt++;
                }
                cnt++;
            }

            done[now] = true;
        }
    }
}
/*
1
5
3 3 1 2 1

1
7
2 3 4 2 6 7 5

1
8
1 2 3 4 5 6 7 8
*/