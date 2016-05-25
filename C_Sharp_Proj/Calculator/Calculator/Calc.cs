using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Calc
    {
        public double variable1 = 0;
        public double variable2 = 0;
        public string operationType = "";
        public bool firstOperation = true;
        public string Calculation(double variable1, double variable2, string operationType)
        {
            switch (operationType)
            {
                case "+":
                    return (variable1 + variable1).ToString();
                case "-":
                    return (variable1 - variable2).ToString();
                case "*":
                    return (variable1 * variable2).ToString();
                case "/":
                    if (variable2 != 0)
                        return (variable1 / variable2).ToString();
                    else
                        return "DIV BY ZERO";
                default:
                    return "0";
            }            
        }
    }
}
