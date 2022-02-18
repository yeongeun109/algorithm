namespace study
{
    internal class 구현_20057_마법사상어와토네이도
    {
        static int N;
        static double[,] percent = new double[5, 5]
        {
            { 0, 0, 0.02, 0, 0 },
            { 0, 0.1, 0.07, 0.01, 0 },
            { 0.05, 0, 0, 0, 0 },
            { 0, 0.1, 0.07, 0.01, 0 },
            { 0, 0, 0.02, 0, 0 }
        };

        static void Main(string[] args)
        {
            N = int.Parse(Console.ReadLine());
            int[,] map = new int[N, N];

            for (int i = 0; i < N; i++)
            {
                string[] str = Console.ReadLine().Split(' ');
                for (int j = 0; j < N; j++)
                {
                    map[i, j] = int.Parse(str[j]);
                }
            }

            int res = 0;
            int x = N/2, y = N/2 - 1;
            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };
            int direct = 1, directNum = 1;

            while(x != 0 && y != 0)
            {
                // 모래 날리기


                // 방향 바꾸기
                if(++directNum == 2)
                {
                    direct++;
                    if (direct == 4)
                        direct -= 4;
                }
            }
        }

        static void turn()
        {
            double[,] tmp = new double[5, 5];
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    tmp[i, j] = percent[j, (N - 1) - i];
                }
            }

            percent = (double[,])tmp.Clone();

            /*for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    Console.Write(tmp[i, j] + "\t");
                }
                Console.WriteLine();
            }
            Console.WriteLine();*/
        }
    }
}
