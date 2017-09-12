using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using StudentMis.Share;

namespace StudentMis
{
    public partial class StudentAdd : Form
    {
        // 变量 ***************************************************************
        private DBCL.dbSSEntities db2 = new DBCL.dbSSEntities();

        // 函数 ***************************************************************
        // 初始化控件
        private void InitControls()
        {
            lbMessage.Text = "";
        }
        
        // 构造
        public StudentAdd()
        {
            InitializeComponent();
        }

        // 事件 ***************************************************************
        // 加载
        private void StudentAdd_Load(object sender, EventArgs e)
        {
            InitControls();
        }
        
        // 关闭
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        // 添加
        private void btnAdd_Click(object sender, EventArgs e)
        {
            // 变量
            string strID = "";
            string strName = "";
            int intAge = 0;

            lbMessage.Text = "";

            // 校验
            if(tbID.Text.Trim()=="")
            {
                lbMessage.Text = "学号不能为空!";
                //MessageBox.Show("学号不能为空!");
                tbID.Focus();
                return;
            }
            if (tbName.Text.Trim() == "")
            {
                lbMessage.Text = "姓名不能为空!";
                //MessageBox.Show("姓名不能为空!");
                tbName.Focus();
                return;
            }
            if(Validator.IsInteger(tbAge.Text.Trim())==false)
            {
                lbMessage.Text = "请输入整数!";
                //MessageBox.Show("请输入整数!");
                tbAge.Focus();
                return;
            }

            // 获取数据
            strID = tbID.Text.Trim();
            strName = tbName.Text.Trim();
            intAge = Convert.ToInt32(tbAge.Text.Trim());
            
            // 检验学号是否重复
            if(db2.Students.Any(m=>m.ID==strID)==true)
            {
                MessageBox.Show("学号重复!");
                tbID.Focus();
                return;
            }

            DBCL.Student model = new DBCL.Student();

            model.ID = strID;
            model.Name = strName;
            model.Age = intAge;
            try
            {
                db2.Students.Add(model);
                db2.SaveChanges();
            }
            catch
            {
                MessageBox.Show("添加失败!");
                return;
            }

           MessageBox.Show("添加成功!");



        }

        
    }
}
