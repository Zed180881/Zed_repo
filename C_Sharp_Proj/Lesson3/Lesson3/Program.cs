using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lesson3
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Введите тип машины:");
            Console.WriteLine("VAZ - для выбора ВАЗ 2105");
            Console.WriteLine("Lambo - для выбора Lamborgini");
            Console.WriteLine("Ferrari - для выбора Ferrari");

            string type = Console.ReadLine();

            Car chosenCar = GetCarByType(type);
            chosenCar.Drive();

            Console.WriteLine("Вы выбрали:");
            Console.WriteLine(chosenCar.ToString());

            Console.ReadKey();
        }

        static Car GetCarByType(string type)
        {
            switch (type)
            {
                case "VAZ":
                    return new Vaz();
                case "Lambo":
                    return new Lamborgini();
                case "Ferrari":
                    return new Ferrari();
                default:
                    return null;
            }
        }
    }
}
