using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu1
{
    abstract class People
    {
        public string name;
        public int age;

        public People()
        { 
        }
        public People(string name,int age)
        {
            this.name = name;
            this.age = age;
        }

        public void Work()
        {
            Console.WriteLine("姓名：{0} 年龄：{1}",name,age);
        }
    }
}
