namespace study
{
    internal class KRU_4386별자리만들기
    {
        static int[] parent;
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double[,] loc = new double[n, 2];
            List<double[]> list= new List<double[]>();
            parent = new int[n];

            for(int i = 0; i < n; i++)
            {
                string[] str = Console.ReadLine().Split(" ");
                loc[i, 0] = double.Parse(str[0]);
                loc[i, 1] = double.Parse(str[1]);
                parent[i] = i;
            }

            for(int i = 0; i < n; i++)
            {
                for(int j = i + 1; j < n; j++)
                {
                    double distance = Math.Sqrt(Math.Pow(Math.Abs(loc[i, 0] - loc[j, 0]), 2) + Math.Pow(Math.Abs(loc[i, 1] - loc[j, 1]), 2));
                    list.Add(new double[] { i, j, distance });
                }
            }

            list.Sort((e1, e2) => e1[2].CompareTo(e2[2]));
            int cnt = 0;
            double res = 0;
            for(int i = 0; i < list.Count; i++)
            {
                double[] tmp = list[i];
                if (!union((int)tmp[0], (int)tmp[1])){
                    res += tmp[2];
                    cnt++;
                    if (cnt == n)
                        break;
                }
            }

            Console.Write(res);
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
                return true;

            parent[rootY] = rootX;
            return false;
        }
    }
}
