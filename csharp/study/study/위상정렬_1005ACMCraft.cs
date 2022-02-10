namespace study
{
    internal class _1005ACMCraft
    {
        static int[] d;
        static List<int>[] list;
        static void Main(string[] args)
        {
            int T = int.Parse(Console.ReadLine());
            for(int t = 0; t < T; t++)
            {
                string[] str = Console.ReadLine().Split(' ');
                int N = int.Parse(str[0]);
                int K = int.Parse(str[1]);
                d = new int[N];
                list = new List<int>[N];
                int[] income = new int[N];
                int[] time = new int[N];

                str = Console.ReadLine().Split(' ');
                for(int i = 0; i < N; i++)
                {
                    d[i] = int.Parse(str[i]);
                    list[i] = new List<int>();
                }

                for(int i = 0; i < K; i++)
                {
                    str = Console.ReadLine().Split(' ');
                    int from = int.Parse(str[0]) - 1;
                    int to = int.Parse(str[1]) - 1;
                    list[from].Add(to);
                    income[to]++;
                }

                Queue<int[]> q = new Queue<int[]>();
                int goal = int.Parse(Console.ReadLine()) - 1;

                for(int i = 0; i < N;  i++)
                {
                    if(income[i] == 0)
                    {
                        q.Enqueue(new int[] { i, i });
                    }
                }

                int[] perhaps = new int[N];
                while(q.Count != 0)
                {
                    int[] tmp = q.Dequeue();
                    if (tmp[0] == tmp[1])
                        time[tmp[0]] += d[tmp[0]];
                    else
                    {
                        int max = Math.Max(perhaps[tmp[0]], time[tmp[1]]);
                        time[tmp[0]] += d[tmp[0]] + max;
                    }

                    if (tmp[0] == goal)
                        break;

                    for(int i = 0; i < list[tmp[0]].Count; i++)
                    {
                        int next = list[tmp[0]][i];
                        if(--income[next] == 0)
                        {
                            q.Enqueue(new int[] { next, tmp[0] });
                        }
                        else
                        {
                            perhaps[next] = Math.Max(time[tmp[0]], perhaps[next]);
                        }
                        
                    }
                }

                Console.WriteLine(time[goal]);
            }
        }
    }
}