namespace study
{
    internal class KRU_11724_연결요소의개수
    {
        static int N;
        static int[] parent, size;
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            N = int.Parse(str[0]);
            int M = int.Parse(str[1]);
            parent = new int[N + 1];
            size = new int[N + 1];

            for (int i = 1; i <= N; i++)
                parent[i] = i;

            for (int i = 1; i <= M; i++)
            {
                str = Console.ReadLine().Split(' ');
                union(int.Parse(str[0]), int.Parse(str[1]));
            }

            List<int> list = new List<int>();
            int cnt = 0;
            for(int i = 1; i <= N; i++)
            {
                int num = find(parent[i]);
                if (!list.Contains(num))
                {
                    list.Add(num);
                    cnt++;
                }
            }
            Console.WriteLine(cnt);
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

            if (rootX == rootY)
            {
                return true;
            }

            if (rootX > rootY)
                parent[rootX] = rootY;
            else
                parent[rootY] = rootX;
            return false;
        }
    }
}