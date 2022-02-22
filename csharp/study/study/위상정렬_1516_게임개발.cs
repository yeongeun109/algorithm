namespace study
{
    internal class 위상정렬_1516_게임개발
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] building = new int[N + 1];
            int[] time = new int[N + 1];
            List<int>[] list = new List<int>[N + 1];
            
            for(int i = 1; i <= N; i++)
            {
                list[i] = new List<int>();
            }

            for(int i = 1; i <= N; i++)
            {
                string[] str = Console.ReadLine().Split(' ');
                time[i] = int.Parse(str[0]);
                for(int j = 1; j < str.Length - 1; j++)
                {
                    int to = int.Parse(str[j]);
                    building[i]++;
                    list[to].Add(i);
                }
            }

            Queue<int> q = new Queue<int>();
            for(int i = 1; i <= N; i++)
            {
                if (building[i] == 0)
                    q.Enqueue(i);
            }
            int[] cnt = new int[N + 1];
            int[] perhaps = new int[N + 1];

            while(q.Count > 0)
            {
                int curr = q.Dequeue();
                cnt[curr] += time[curr];

                for(int i = 0; i < list[curr].Count; i++)
                {
                    int to = list[curr][i];
                    if(--building[to] == 0)
                    {
                        q.Enqueue(to);
                        cnt[to] += Math.Max(perhaps[to], cnt[curr]);
                    }
                    else
                    {
                        perhaps[to] = Math.Max(perhaps[to], cnt[curr]);
                    }
                }
            }

            for (int i = 1; i <= N; i++)
            {
                Console.WriteLine(cnt[i]);
            }
        }
    }
}