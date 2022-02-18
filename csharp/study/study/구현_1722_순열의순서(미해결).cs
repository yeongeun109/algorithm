using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace study
{
    internal class BF_1038_감소하는수
    {
        static int n, goal;
        static int[] arr;
        static void Main(string[] args)
        {
            n = int.Parse(Console.ReadLine());
            arr = new int[n + 1];
            selected = new bool[n + 1];
            fact = new int[21];

            for(int i = 1; i < 21; i++)
            {
                fact[i] = i * fact[i - 1];
            }

            string[] str = Console.ReadLine().Split(' ');
            if (int.Parse(str[0]) == 1)
            {
                goal = int.Parse(str[1]);
                
            }
            else
            {
                for (int j = 0; j < n; j++)
                {
                    arr[j] = int.Parse(str[j]);
                }
                Console.Write(count());
            }

        }

        static bool[] selected;
        static int count()
        {
            int cnt = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 1; j < arr[i]; j++)
                {
                    if (!selected[j])
                    {
                        cnt += fact[n-i - 1];
                    }

                }
                    selected[arr[i]] = true;
            }

            return cnt;
        }

        static int[] fact;

    }
}
