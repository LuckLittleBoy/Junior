using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace renwu3
{
    public class Person
    {
        protected string MyName;
        protected string MyGender;
        protected string MyYearOfBirth;
        protected int Age;

        public Person(string name,string gender,string yearOfBirth)
        {
            this.MyName = name;
            this.MyGender = gender;
            this.MyYearOfBirth = yearOfBirth;
            this.Age = 2016 - int.Parse(yearOfBirth) + 1;
        }
        public void Print()
        {
            if (MyGender == "男")
            {
                Console.WriteLine("姓名：{0}, 先生, 生日：{1}, 年纪：{2}", MyName, MyYearOfBirth, Age);
            }
            if (MyGender == "女")
            {
                Console.WriteLine("姓名：{0}, 女士, 生日：{1}, 年纪：{2}", MyName, MyYearOfBirth, Age);
            }
        }
    }
}
