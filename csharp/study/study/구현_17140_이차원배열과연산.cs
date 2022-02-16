using System.Linq;

namespace study
{
    internal class 구현_17140_이차원배열과연산
    {
        static int[,] arr = new int[101, 101];
        static int cnt = 0;
        static int maxR = 3, maxC = 3;
        static void Main(string[] args)
        {
            string[] str = Console.ReadLine().Split(' ');
            int r = int.Parse(str[0]) - 1;
            int c = int.Parse(str[1]) - 1;
            int k = int.Parse(str[2]);

            for(int i = 0; i < 3; i++)
            {
                str = Console.ReadLine().Split(' ');
                for(int j = 0; j < 3; j++)
                {
                    arr[i, j] = int.Parse(str[j]);
                }
            }

            bool over = false;
            while(arr[r, c] != k)
            {
                if(++cnt == 101)
                {
                    over = true;
                    break;
                }

                if(maxR >= maxC)
                {
                    calc(0);
                }
                else
                {
                    calc(1);
                }
            }

            if (over)
                Console.Write(-1);
            else
                Console.Write(cnt);
        }

        static void calc(int type)
        {
            if(type == 0) // 행 정렬
            {
                for (int i = 0; i < 100; i++) {
                    SortedDictionary<int, int> nums = new SortedDictionary<int, int>();
                    for (int j = 0; j < 100; j++)
                    {
                        if (arr[i, j] == 0)
                            continue;
                        if (!nums.ContainsKey(arr[i, j]))
                        {
                            nums.Add(arr[i, j], 1);
                        }
                        else
                        {
                            nums[arr[i, j]]++;
                        }
                    }
                    List<int[]> list = new List<int[]>();
                    int y = 0;
                    foreach(var pair in nums)
                    {
                        list.Add(new int[] {pair.Key, pair.Value});
                    }
                    list.Sort((e1, e2) =>
                    {
                        int res = e1[1] - e2[1];
                        return res != 0 ? res : e1[0] - e2[0];
                    });
                    for(int j = 0; j < list.Count; j++)
                    {
                        arr[i, y++] = list[j][0];
                        arr[i, y++] = list[j][1];
                    }
                    maxC = Math.Max(maxC, nums.Count() * 2);

                    for (int j = y; j < 100; j++)
                    {
                        arr[i, j] = 0;
                    }
                }
            }
            else // 열 정렬
            {
                for (int i = 0; i < 100; i++)
                {
                    SortedDictionary<int, int> nums = new SortedDictionary<int, int>();
                    for (int j = 0; j < 100; j++)
                    {
                        if (arr[j, i] == 0)
                            continue;
                        if (!nums.ContainsKey(arr[j, i]))
                        {
                            nums.Add(arr[j, i], 1);
                        }
                        else
                        {
                            nums[arr[j, i]]++;
                        }
                    }

                    List<int[]> list = new List<int[]>();
                    int x = 0;
                    foreach (var pair in nums)
                    {
                        list.Add(new int[] { pair.Key, pair.Value });
                    }

                    list.Sort((e1, e2) =>
                    {
                        int res = e1[1] - e2[1];
                        return res != 0 ? res : e1[0] - e2[0];
                    });

                    for (int j = 0; j < list.Count; j++)
                    {
                        arr[x++, i] = list[j][0];
                        arr[x++, i] = list[j][1];
                    }
                    maxR = Math.Max(maxR, nums.Count() * 2);

                    for (int j = x; j < 100; j++)
                    {
                        arr[j, i] = 0;
                    }

                }
            }
        }
    }

}
