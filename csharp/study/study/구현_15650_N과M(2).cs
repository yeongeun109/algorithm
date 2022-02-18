namespace study
{
    internal class 구현_15650_N과M_2_
    {
        static int N, M;
        static int[] nums;
        
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            N = int.Parse(str[0]);
            M = int.Parse(str[1]);
            nums = new int[N + 1];

            comb(1, 1);
        }

        static void comb(int cnt, int start)
        {
            if(cnt == M + 1)
            {
                for(int i = 1; i <= M; i++)
                {
                    Console.Write(nums[i] + " ");
                }
                Console.WriteLine();
                return;
            }

            for(int i = start; i <= N; i++)
            {
                nums[cnt] = i;
                comb(cnt + 1, i + 1);
            }
        }
    }
}
