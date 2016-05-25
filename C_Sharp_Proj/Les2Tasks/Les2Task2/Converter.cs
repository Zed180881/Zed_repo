using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Les2Task2
{
    class Converter
    {
        double usd, eur, rub;

        public Converter(double usd, double eur, double rub)
        {
            this.usd = usd;
            this.eur = eur;
            this.rub = rub;
        }
        public double Uah_to_usd (double sum)
        {
            return sum / usd;
        }
        public double Uah_to_eur(double sum)
        {
            return sum / eur;
        }
        public double Uah_to_rub(double sum)
        {
            return sum / rub;
        }
        public double Usd_to_uah(double sum)
        {
            return sum * usd;
        }
        public double Eur_to_uah(double sum)
        {
            return sum * eur;
        }
        public double Rub_to_uah(double sum)
        {
            return sum * rub;
        }

    }
}
