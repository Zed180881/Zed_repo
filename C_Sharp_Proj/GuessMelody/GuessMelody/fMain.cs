using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GuessMelody
{
    public partial class fMain : Form
    {
        fParam fp = new fParam();
        fGame fg = new fGame();       

        public fMain()
        {
            InitializeComponent();
            Victorina.ReadParam();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnParam_Click(object sender, EventArgs e)
        {
            Hide();
            fp.ShowDialog();
            Show();
        }

        private void btnPlay_Click(object sender, EventArgs e)
        {
            Hide();
            fg.ShowDialog();
            Show();
        }

        private void fMain_Load(object sender, EventArgs e)
        {
            Victorina.ReadParam();
            Victorina.ReadMusic();
        }
    }
}
