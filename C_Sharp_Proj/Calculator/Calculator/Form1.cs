using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculator
{
    public partial class MainForm : Form
    {
        Calc calc = new Calc();
        public MainForm()
        {
            InitializeComponent();            
        }

        private void экономияТопливаToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            tbShow.Text = "0";            
        }

        private void btn7_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "7";
            }
            else
            {
                tbShow.Text += "7";
            }
        }

        private void btn8_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "8";
            }
            else
            {
                tbShow.Text += "8";
            }
        }

        private void btn9_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "9";
            }
            else
            {
                tbShow.Text += "9";
            }
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "4";
            }
            else
            {
                tbShow.Text += "4";
            }
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "5";
            }
            else
            {
                tbShow.Text += "5";
            }
        }

        private void btn6_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "6";
            }
            else
            {
                tbShow.Text += "6";
            }
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "1";
            }
            else
            {
                tbShow.Text += "1";
            }
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "2";
            }
            else
            {
                tbShow.Text += "2";
            }
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "3";
            }
            else
            {
                tbShow.Text += "3";
            }
        }

        private void btn0_Click(object sender, EventArgs e)
        {
            if (tbShow.Text == "0")
            {
                tbShow.Text = "0";
            }
            else
            {
                tbShow.Text += "0";
            }
        }

        private void btnComa_Click(object sender, EventArgs e)
        {
            if (!tbShow.Text.Contains(","))
                tbShow.Text += ",";
        }

        private void btnCE_Click(object sender, EventArgs e)
        {
            tbShow.Text = "0";
        }

        private void btnC_Click(object sender, EventArgs e)
        {

        }

        private void btnPlus_Click(object sender, EventArgs e)
        {
                        
        }
    }
}
