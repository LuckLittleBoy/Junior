using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu1
{
    class Student:People
    {
        public string school;

        public Student(string name, int age, string school)
        {
            this.name = name;
            this.age = age;
            this.school = school;
        }
        public new void Work()
        {
            Console.WriteLine("姓名：{0} 年龄：{1} 学校：{2}",name,age,school);
        }
    }
}
