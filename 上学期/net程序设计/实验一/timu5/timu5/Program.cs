using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace timu5
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请输入一个二维数组的行数：");
            int lx = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("请输入一个二维数组的列数：");
            int ly = Convert.ToInt32(Console.ReadLine());

            int[,] arry = new int[lx,ly];
            string s;
            string[,] s1=new string[lx,ly];
            int index;
            int m = 0;
            bool flag = false;

            Console.WriteLine("请输入二维数组的内容：");

            for (int i = 0; i < lx; i++)
            {
                s = Console.ReadLine();
                string[] data = s.Split(' ');
                for (int j = 0; j < ly; j++ )
                {
                    arry[i,j] = Convert.ToInt32(data[j]);
                }
            }
            for (int i = 0; i < lx; i++)
            {
                index = arry[i, 0];
                flag = false;
                for (int j = 0; j < ly; j++)
                {
                    if (index < arry[i, j])
                    {
                        m = j;
                        index = arry[i, j];
                    }
                }
                
                for (int k = 0; k < lx; k++)
                {
                    if (index > arry[k, m])
                    {
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                {
                    Console.WriteLine("数组鞍点为：{0}", index);
                }
            }
            if (flag)
            {
                Console.WriteLine("数组无鞍点！");
            }
            Console.Read();
        }
    }
}
