using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Media;

namespace GuessMelody
{
    public partial class fMessage : Form
    {
        int timeAnswer = 10;

        public fMessage()
        {
            InitializeComponent();
        }

        private void fMessage_Load(object sender, EventArgs e)
        {
            timeAnswer = 10;
            timer1.Start();

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            timeAnswer--;
            lblTimeAnswer.Text = timeAnswer.ToString();
            if (timeAnswer == 0)
            {
                timer1.Stop();
                SoundPlayer sp = new SoundPlayer("Resources\\alert.wav");
                sp.PlaySync();
                DialogResult = DialogResult.No;
                this.Close();
            }
        }

        private void fMessage_FormClosed(object sender, FormClosedEventArgs e)
        {
            timer1.Stop();
        }

        private void lblAnswer_Click(object sender, EventArgs e)
        {
            var mp3file = TagLib.File.Create(Victorina.answer);
            lblAnswer.Text = mp3file.Tag.FirstArtist+" - "+mp3file.Tag.Title;
        }
    }
}
