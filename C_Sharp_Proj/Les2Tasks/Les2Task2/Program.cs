using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Les2Task2
{
    class Program
    {
        static void Main(string[] args)
        {
            Converter kurs = new Converter(26.600686, 29.981633, 0.38659);

            Console.WriteLine("100 гривeн = {0} usd", kurs.Uah_to_usd(100));
            Console.WriteLine("100 гривeн = {0} eur", kurs.Uah_to_eur(100));
            Console.WriteLine("100 гривeн = {0} rub", kurs.Uah_to_rub(100));
            Console.WriteLine("100 usd = {0} гривен", kurs.Usd_to_uah(100));
            Console.WriteLine("100 eur = {0} гривен", kurs.Eur_to_uah(100));
            Console.WriteLine("100 rub = {0} гривен", kurs.Rub_to_uah(100));

            Console.ReadKey();
        }
    }
}
