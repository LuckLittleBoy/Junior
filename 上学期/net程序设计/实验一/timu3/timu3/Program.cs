using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace timu3
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = 3;
            while((num%2!=1)||(num%3!=1)||(num%4!=1))
            {
                num++;
            }
            Console.WriteLine("鸡蛋数量:{0}",num);
            Console.Read();
        }
    }
}
