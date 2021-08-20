/*
Реализовать интерактивное консольное приложение.

Программа оперирует координатами точек (парами x, y), которые могут попадать в следующие группы:
1 - точка лежит на или выше линии y=x¹
2 - точка лежит на или выше линии y=x²
3 - точка лежит на или выше линии y=x³

Необходимо реализовать команды:
add <point> - добавить в память программы точки, координаты передаются парами чисел через пробел
прим. add 1 1 -2 -3 //добавить 2 точки: (1,1) и (-2,-3)

print - напечатать построчно каждую из трех групп (входящие в них точки)
если в группу не попадает ни одна точка, то вывести сообщение, что группа пуста
последней строкой напечатать количество точек, не вошедших ни в одну группу

print <group_num> - напечатать одним списком точки, входящие в группу(ы) переданную(ые) параметром <group_num>
прим. print 1 2

remove <group_num> - удалить из памяти все точки, входящие в группу(ы) <group_num>
прим. remove 2 3

clear - очистить память

help - вывод справки по командам

Исходный код направить в виде архива или выложить на GitHub.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Тестовое задание DexSys");

        Scanner scanner = new Scanner(System.in);
        boolean isFinish = false;

        //Создаем группы или графики
        Graphics G1 = new Graphics(1);
        Graphics G2 = new Graphics(2);
        Graphics G3 = new Graphics(2);
        Graphics GEmpty = new Graphics();

        Graphics[] graphics = new Graphics[4];
        graphics[0] = G1;
        graphics[1] = G2;
        graphics[2] = G3;
        graphics[3] = GEmpty;

        while (!isFinish) {
            System.out.println();
            System.out.println("Ожидается ввод команды. Для списка команд введите - help");
            String expression = scanner.nextLine();

            Command command = new Command(splitExpression(expression));
            try {
                command.doCommand();
                if (command.getCommand().contains("add")) {
                    PointWorker.start(command.getCommand(), command.getSubcommand(), graphics);
                } else if ((command.getCommand().contains("print")) || ((command.getCommand().contains("remove")))) {
                    PointWorker.start(command.getCommand(), graphics, command.getSubcommand());
                } else if ((command.getCommand().contains("clear")) || ((command.getCommand().contains("help")))) {
                    PointWorker.start(command.getCommand(), graphics);
                    continue;
                } else if (command.getCommand().contains("exit")){
                    isFinish = true;
                }
            } catch (NullPointerException e) {
                System.out.println("Ошибка ввода!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка ввода данных");
            }
        }
    }

    public static String[] splitExpression(String expression){
        String[] expressionArr = expression.split(" ", 2);
        return expressionArr;
    }
}
