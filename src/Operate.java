public class Operate  {
    public static int solve (int first,char operation,int second) throws Exception{
        if(first>10||second>10||first<1||second<1)
            throw new Exception("Операции только с числами от 1 до 10 включительно");
        if(operation!='+'&&operation!='-'&&operation!='*'&&operation!='/')
            throw new Exception("Неподдерживаемый тип операции");
        if (operation=='+')
        {
            return first+second;
        }
        if (operation=='-')
        {
            return first-second;
        }
        if (operation=='*')
        {
            return first*second;
        }
            return first/second; //не нужна проверка if, поскольку других операций не осталось,а иные вариации отсекаются исключением
    };
}
