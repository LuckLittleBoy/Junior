using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace timu4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请输入数组长度");
            int length = Convert.ToInt32(Console.ReadLine());
            int[] arry = new int[length];

            for (int i = 0; i < length; i++)
            {
                arry[i] = Convert.ToInt32(Console.ReadLine());
            }

            int m = 0, n = 0;
            for (int i = 0; i < length; i++)
            {
                if (arry[i] % 2 == 0)
                    m += arry[i];
                if (arry[i] % 2 == 1)
                    n += arry[i];
            }

            Console.WriteLine("数组中奇数和为：{0} 偶数和为：{1}", m, n);
            Console.Read();
        }
    }
}
