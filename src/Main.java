import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите пример");
        char[] primer; //обьявление массива primer типа char
         Scanner scan = new Scanner(System.in); //Обьявление сканера
        primer = scan.nextLine().toCharArray(); //считывание примера в массив primer
         scan.close();//Закрытие сканера
        String first = ""; //переменная для первого числа в примере
        char operation = 0; //переменная для определения операции
        String second = ""; //переменная для второго числа в примере
        int type1=4;//переменная для определения типа операции (с арабскими/римскими числами)
        int type2=4;//переменная для определения типа операции (с арабскими/римскими числами)
        int operands=0;//переменная для подсчета знаков операций
        for (int i=0;i<primer.length;i++){      //цикл для прохождения по всему массиву
            if (primer[i]=='-'&&i==0){/*first = first+primer[i];i++;*/throw new Exception("Калькулятор не умеет работать с отрицательными числами");}
            if (primer[i]=='I'||primer[i]=='V'||primer[i]=='X') {type1=1;} //проверка на римские числа
            else if(type1!=1){type1=0;} //если нет- значит не римские (первая проверка для того, что бы тип не менялся в цикле на последущих итерациях)

            if (primer[i]=='*'||primer[i]=='-'||primer[i]=='+'||primer[i]=='/'){


                operation=primer[i];
                for (int i2=i+1;i2<primer.length;i2++){
                    if (primer[i2]=='-'){/*second = second+primer[i2];i2++;*/throw new Exception("Калькулятор не умеет работать с отрицательными числами");}
                    second=second+primer[i2];//внесение части числа в перменную второго операнда
                    if (primer[i2]=='I'||primer[i2]=='V'||primer[i2]=='X') {type2=1;} //проверка на римские числа
                    else {type2=0;} //если нет - значит не римские
                }
                break;

            }
            first = first+primer[i];//внесение части числа в переменную первого операнда
            }
        for (int i=0;i<primer.length;i++){  //цикл проверки колличества операторов
            if (primer[i]=='*'||primer[i]=='-'||primer[i]=='+'||primer[i]=='/'){
                operands++;
                if (operands>1)
                    throw new Exception("Калькулятор не умеет оперировать более, чем двумя числами и одним знаком");
            }
        }
       if (type1==0&&type2==0) //проверка соответсвия типовX
          System.out.println(Operate.solve(Integer.parseInt(first),operation,Integer.parseInt(second))); //вывод
       else{
        if (type1==1&&type2==1)//проверка соответсвия типов
        {int otvet = 0;
            otvet = Operate.solve(Convert.RtoA(first),operation,Convert.RtoA(second));
            if (otvet<1){throw new Exception("В римской системе не может быть числа меньше 1");}
            System.out.println(Convert.AtoR(otvet));} //вывод
        else throw new Exception("Строка не является математической операцией");
       }


        }

        }

