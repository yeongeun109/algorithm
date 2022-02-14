namespace study
{
    internal class KRU_1647_도시분할계획
    {
        static List<int[]> list = new List<int[]>();
        static int[] parent;
        static int N, res = 0;

        static public void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            N = int.Parse(str[0]); // 집
            int M = int.Parse(str[1]); // 길
            parent = new int[N];

            for(int i = 0; i < N; i++)
            {
                parent[i] = i;
            }

            for(int i = 0; i < M; i++)
            {
                str = Console.ReadLine().Split(" ");
                int a = int.Parse(str[0]) - 1;
                int b = int.Parse(str[1]) - 1;
                int cost = int.Parse(str[2]);
                list.Add(new int[] { a, b, cost });
            }

            list.Sort((e1, e2) => e1[2].CompareTo(e2[2]));

            make();
            int last = 0;
            for (int i = 0; i < list.Count; i++)
            {
                int[] tmp = list[i];
                if (find(tmp[0]) != find(tmp[1]))
                {
                    union(tmp[0], tmp[1]);
                    res += tmp[2];
                    last = tmp[2];
                }
            }
            res -= last;

            Console.WriteLine(res);
        }
        
        static void make()
        {
            for(int i = 0; i < N; i++)
            {
                parent[i] = i;
            }
        }
        static int find(int x)
        {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        static bool union(int x, int y)
        {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY) {
                return true;
            }

            parent[rootY] = rootX;
            return false;
        }
    }
}
