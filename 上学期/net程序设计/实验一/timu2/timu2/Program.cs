using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace timu2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请输入月份：");
            int month = Convert.ToInt32(Console.ReadLine());

            while(month < 1 || month > 12)
            {
                Console.WriteLine("输入错误，请重新输入：");
                month = Convert.ToInt32(Console.ReadLine());
            }

            if(month >= 1&&month <= 3)
                Console.WriteLine("春季");
            else if(month >= 4&&month<=6)
                Console.WriteLine("夏季");
            else if (month >= 7 && month <= 9)
                Console.WriteLine("秋季");
            else
                Console.WriteLine("冬季");

            Console.Read();
        }
    }
}
