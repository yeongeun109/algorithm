namespace study
{
    internal class 구현_18808_스티커붙이기
    {
        static int N, M, K;
        static int[,] notebook, sticker;
        static int tmpN, tmpM;
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            N = int.Parse(str[0]);
            M = int.Parse(str[1]);
            K = int.Parse(str[2]);

            notebook = new int[N, M];
            int cnt = 0;
            
            for(int i = 0; i < K; i++)
            {
                str = Console.ReadLine().Split(' ');
                tmpN = int.Parse(str[0]);
                tmpM = int.Parse(str[1]);
                sticker = new int[tmpN, tmpM];

                for (int j = 0; j < tmpN; j++)
                {
                    str = Console.ReadLine().Split(" ");
                    for (int k = 0; k < tmpM; k++)
                    {
                        sticker[j, k] = int.Parse(str[k]);
                    }
                }

                int turnCnt = 0;
                while (true)
                {
                    bool sticked = false;
                    for (int j = 0; j < N; j++)
                    {
                        for (int k = 0; k < M; k++)
                        {
                            bool avail = false;
                            for (int x = 0; x < tmpN; x++)
                            {
                                for (int y = 0; y < tmpM; y++)
                                {
                                    if (j + x >= N || k + y >= M)
                                    {
                                        avail = true;
                                        break;
                                    }    
                                    if (sticker[x, y] == 1)
                                    {
                                        if (notebook[j + x, k + y] != 0)
                                        {
                                            avail = true;
                                            break;
                                        }
                                    }
                                }

                                if (avail)
                                    break;
                            }

                            if (!avail)
                            {
                                for (int x = 0; x < tmpN; x++)
                                {
                                    for (int y = 0; y < tmpM; y++)
                                    {
                                        if (j + x >= N || k + y >= M)
                                            continue;
                                        if (sticker[x, y] == 1)
                                        {
                                            notebook[j + x, k + y] = i + 1;
                                            cnt++;
                                        }
                                    }
                                }
                                sticked = true;
                                break;
                            }
                        }

                        if (sticked)
                            break;
                    }
   
                    if (!sticked && turnCnt < 4)
                    {
                        turn();
                        turnCnt++;
                    }
                    else
                        break;
                }
            }
            Console.WriteLine(cnt);
        }

        static void turn()
        {
            int[,] tmp = new int[tmpM, tmpN];

            for(int i = 0; i < tmpN; i++)
            {
                for(int j = 0; j < tmpM; j++)
                {
                    tmp[j, (tmpN - 1) - i] = sticker[i, j];
                }
            }

            int temp = tmpN;
            tmpN = tmpM;
            tmpM = temp;
            sticker = (int[,])tmp.Clone();
        }
    }
}
