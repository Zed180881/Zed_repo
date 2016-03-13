using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Snake
{
    class VerticalLine : Figure
    {
        public VerticalLine(int yDown, int yUp, int x, char sym)
        {
            pList = new List<Point>();
            for (int y = yDown; y <= yUp; y++)
            {
                pList.Add(new Point(x, y, sym));
            }
        }
    }
}
