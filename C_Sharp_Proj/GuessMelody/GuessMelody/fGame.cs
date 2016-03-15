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
    public partial class fGame : Form
    {
        Random rnd = new Random();
        int musicDuration;
        bool[] players = new bool[2];

        public fGame()
        {
            InitializeComponent();
        }

        void MakeMusic()
        {
            if (Victorina.list.Count == 0)
            {
                EndGame();
                MessageBox.Show("Конец игры - закончились мелодии!");
            }
            else
            {
                musicDuration = Victorina.musicDuration;
                int n = rnd.Next(0, Victorina.list.Count);
                WMP.URL = Victorina.list[n];
                Victorina.answer = WMP.URL;
                Victorina.list.RemoveAt(n);
                lblMelodyCount.Text = Victorina.list.Count.ToString();
                timer1.Start();
                players[0] = false;
                players[1] = false;
            }            
        }

        private void btnNextSong_Click(object sender, EventArgs e)
        {            
            MakeMusic();
        }

        private void fGame_FormClosed(object sender, FormClosedEventArgs e)
        {
            WMP.Ctlcontrols.stop();            
        }

        private void btnPause_Click(object sender, EventArgs e)
        {
            GamePause();
        }

        private void btnContinue_Click(object sender, EventArgs e)
        {
            GameContinue();
        }

        void GamePause()
        {
            WMP.Ctlcontrols.pause();
            timer1.Stop();
        }

        void GameContinue()
        {
            WMP.Ctlcontrols.play();
            timer1.Start();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void fGame_Load(object sender, EventArgs e)
        {
            lblMelodyCount.Text = Victorina.list.Count.ToString();
            progressBar1.Maximum = Victorina.gameDuration;
            progressBar1.Value = 0;
            musicDuration = Victorina.musicDuration;
            lblMusicDuration.Text = musicDuration.ToString();
        }

        void EndGame()
        {
            timer1.Stop();
            WMP.Ctlcontrols.stop();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            musicDuration--;
            lblMusicDuration.Text = musicDuration.ToString();
            progressBar1.Value++;
            if (progressBar1.Value == progressBar1.Maximum)
            {
                EndGame();
                MessageBox.Show("Конец игры - время вышло!");
                return;
            }
            if (musicDuration == 0)
            {
                MakeMusic();
            }
        }

        private void fGame_KeyDown(object sender, KeyEventArgs e)
        {
            if (!timer1.Enabled) return;
            if (players[0] == false && e.KeyData == Keys.A)
            {
                GamePause();
                fMessage fm = new fMessage();
                fm.lblMessage.Text = "Игрок 1";
                SoundPlayer sp = new SoundPlayer("Resources\\Player1.wav");
                sp.PlaySync();
                players[0] = true;
                if (fm.ShowDialog() == DialogResult.Yes)
                {
                    lblCount1.Text = Convert.ToString(Convert.ToInt32(lblCount1.Text) + 1);
                    MakeMusic();
                }
                else
                {
                    GameContinue();
                    lblCount1.Text = Convert.ToString(Convert.ToInt32(lblCount1.Text) - 1);
                }                
            }
            if (players[1]==false && e.KeyData == Keys.P)
            {
                GamePause();
                fMessage fm = new fMessage();
                fm.lblMessage.Text = "Игрок 2";
                SoundPlayer sp = new SoundPlayer("Resources\\Player2.wav");
                sp.PlaySync();
                players[1] = true;
                if (fm.ShowDialog() == DialogResult.Yes)
                {
                    lblCount2.Text = Convert.ToString(Convert.ToInt32(lblCount2.Text) + 1);
                    MakeMusic();
                }
                else
                {
                    GameContinue();
                    lblCount2.Text = Convert.ToString(Convert.ToInt32(lblCount2.Text) - 1);
                }                
            }
        }

        private void WMP_PlayerDockedStateChange(object sender, EventArgs e)
        {
           
        }

        private void WMP_OpenStateChange(object sender, AxWMPLib._WMPOCXEvents_OpenStateChangeEvent e)
        {
            if (Victorina.randomStart)
            {
                if (WMP.openState == WMPLib.WMPOpenState.wmposMediaOpen)
                {
                    WMP.Ctlcontrols.currentPosition = rnd.Next(0, (int)WMP.currentMedia.duration - 20);
                }
            }
        }

        private void lblCount1_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left) lblCount1.Text = Convert.ToString(Convert.ToInt32(lblCount1.Text) + 1);
            if (e.Button == MouseButtons.Right) lblCount1.Text = Convert.ToString(Convert.ToInt32(lblCount1.Text) - 1);

        }

        private void lblCount2_MouseClick(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left) lblCount2.Text = Convert.ToString(Convert.ToInt32(lblCount2.Text) + 1);
            if (e.Button == MouseButtons.Right) lblCount2.Text = Convert.ToString(Convert.ToInt32(lblCount2.Text) - 1);
        }
    }
}
