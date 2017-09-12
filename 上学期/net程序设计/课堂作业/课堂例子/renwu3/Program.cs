using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu3
{
    class Program
    {
        static void Main(string[] args)
        {
            Teacher t = new Teacher("李丽", "女", "1985", "20142478", "2003");
            t.Print();

            Console.ReadLine();
        }
    }
}
