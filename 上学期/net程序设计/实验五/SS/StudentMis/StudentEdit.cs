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
    public partial class StudentEdit : Form
    {
        // 变量 ***************************************************************
        private string mstrID = "";
        private DBCL.dbSSEntities db = new DBCL.dbSSEntities();

        // 函数 ***************************************************************
        // 构造
        public StudentEdit()
        {
            InitializeComponent();
        }

        public StudentEdit(string strID)
        {
            InitializeComponent();
            mstrID = strID;
        }

        // 事件 ***************************************************************
        // 加载
        private void StudentEdit_Load(object sender, EventArgs e)
        {
            lbMessage.Text = "";

            var model = db.Students.FirstOrDefault(m => m.ID == mstrID);

            if (model == null)
            {
                return;
            }


            tbID.Text = model.ID;
            tbID.ReadOnly = true;
            tbName.Text = model.Name;
            tbAge.Text = model.Age.ToString();


        }

        // 关闭
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        // 编辑
        private void btnEdit_Click(object sender, EventArgs e)
        {
            // 变量
            string strID = "";
            string strName = "";
            int intAge = 0;

            lbMessage.Text = "";

            // 校验
            if (tbID.Text.Trim() == "")
            {
                lbMessage.Text = "学号不能为空!";
                //MessageBox.Show("学号不能为空!");
                tbID.Focus();
                return;
            }
            if (tbName.Text.Trim() == "")
            {
                MessageBox.Show("姓名不能为空!");
                tbName.Focus();
                return;
            }
            if (Validator.IsInteger(tbAge.Text.Trim()) == false)
            {
                MessageBox.Show("请输入整数!");
                tbAge.Focus();
                return;
            }

            // 获取数据
            strID = tbID.Text.Trim();
            strName = tbName.Text.Trim();
            intAge = Convert.ToInt32(tbAge.Text.Trim());

            // 编辑
            var model = db.Students.FirstOrDefault(m => m.ID == strID);
            if(model==null)
            {
                MessageBox.Show("该学号在数据库中不存在!");
                return;
            }

            model.Name = strName;
            model.Age = intAge;

            try
            {
                db.SaveChanges();
            }
            catch
            {
                MessageBox.Show("编辑失败!");
                return;
            }

            this.Close();
        }




    }
}
