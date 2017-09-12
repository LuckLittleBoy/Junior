using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu1
{
    class Program
    {
        static void Main(string[] args)
        {
            Student stu = new Student("孟祥通",22,"石家庄铁道大学");
            stu.Work();
            Employer em = new Employer("羊城新",21,"阿里粑粑");
            em.Work();

            Console.ReadLine();
        }
    }
}
