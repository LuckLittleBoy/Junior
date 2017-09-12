using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu1
{
    class Employer:People
    {
        public string workaddress;

        public Employer(string name,int age,string workaddress)
        {
            this.name = name;
            this.age = age;
            this.workaddress = workaddress;
        }

        public new void Work()
        {
            Console.WriteLine("姓名：{0} 年龄：{1} 工作单位：{2}", name, age, workaddress);
        }
    }
}
