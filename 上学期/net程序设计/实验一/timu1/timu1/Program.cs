using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace timu1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请分别输入三角形的三条边长：");
            int length = 3;
            double[] arry = new double[length];
            for (int i = 0; i < length; i++)
            {
                arry[i] = Convert.ToDouble(Console.ReadLine());
            }
            double p = (arry[0] + arry[1] + arry[2]) / 2;
            double s = 0;
            s = p * (p - arry[0]) * (p - arry[1]) * (p - arry[2]);
            s = Math.Sqrt(s);
            Console.WriteLine("三角形周长：{0} 面积：{1}", p * 2, s);

            Console.WriteLine("请分别输入长方形的长宽：");

            double x = Convert.ToDouble(Console.ReadLine());
            double y = Convert.ToDouble(Console.ReadLine());
            double l = 2*(x+y);
            double m = x * y;
            Console.WriteLine("长方形周长：{0} 面积：{1}", l, m);
            Console.Read();
        }
    }
}
