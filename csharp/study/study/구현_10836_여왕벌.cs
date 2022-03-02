using System.Text;

namespace study
{
    internal class 구현_10836_여왕벌
    {
        static int[] map;
        static int M;
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            M = int.Parse(str[0]);
            int N = int.Parse(str[1]);
            map = new int[M * 2 - 1];

            for(int i = 0; i < M * 2 - 1; i++)
            {
                map[i] = 1;
            }
            for(int i = 0; i < N; i++)
            {
                str = Console.ReadLine().Split(' ');
                int zero = int.Parse(str[0]);
                int one = int.Parse(str[1]);

                for (int j = zero; j < zero + one; j++)
                {
                    map[j]++;
                }

                for (int j = zero + one; j < M * 2 - 1; j++)
                {
                    map[j] += 2;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    if(j == 0)
                    {
                        sb.Append(map[M - 1 - i]).Append(' ');
                    }
                    else
                    {
                        sb.Append(map[j + M - 1]).Append(' ');
                    }
                }
                sb.Append('\n');
            }
            Console.Write(sb.ToString());
        }
    }
}
