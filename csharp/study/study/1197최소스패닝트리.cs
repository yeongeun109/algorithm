namespace study
{
    internal class _1197최소스패닝트리
    {
        static int[] parent;
        static int V, E;

        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            V = int.Parse(str[0]);
            E = int.Parse(str[1]);
            List<int[]> list = new List<int[]>();
            parent = new int[V];

            for(int i = 0; i < V; i++)
            {
                parent[i] = i;
            }

            for(int i = 0; i < E; i++)
            {
                str = Console.ReadLine().Split(' ');
                int from = int.Parse(str[0]) - 1;
                int to = int.Parse(str[1]) - 1;
                int cost = int.Parse(str[2]);
                list.Add(new int[] { from, to, cost });
            }

            list.Sort((e1, e2) => e1[2].CompareTo(e2[2]));

            int cnt = 0, res = 0;
            bool[] connected = new bool[V];
            
            for(int i = 0; i < list.Count; i++)
            {
                int[] tmp = list[i];
                if(!union(tmp[0], tmp[1]))
                {
                    res += tmp[2];
                    if (++cnt == V)
                        break;
                }
            }

            Console.WriteLine(res);
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
            if(rootX == rootY)
                return true;

            parent[rootY] = rootX;
            return false;
        }
    }
}