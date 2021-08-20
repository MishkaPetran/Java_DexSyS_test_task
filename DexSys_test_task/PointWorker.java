import java.util.*;

public class PointWorker {
    int[] coordinates;
    static boolean isDumpEmpty = true;

    //add
    public static void start(String command, int[] coordinates, Graphics[] graphics) {
        if (command.contains("add")){
            isHitToGraphic(graphics, createPointList(coordinates));
        }
    }

    //print,  print <...>, remove
    public static void start(String command, Graphics[] graphics, int[] params) {
        if (!isDumpEmpty) {
            if (command.equals("print")) {
                if (params.length > 0) {
                    printGroupPoints(graphics, params);
                } else {
                    printPoints(graphics);
                }
            } else if (command.equals("remove")) {
                if (params.length > 0) {
                removePoints(graphics, params);
                    System.out.println("Выбранные точки удалены");
                }
            }
        } else {
            System.out.println("Память пуста, добавьте точки.");
        }
    }

    //clear и help
    public static void start(String command, Graphics[] graphics) {
            if (command.equals("clear")) {
                removeAllPoints(graphics);
                System.out.println("Все точки удалены.");
            } else if (command.equals("help")) {
                System.out.println(getHelp());
            }
    }

    public static Point[] createPointList(int[] coordinates) {
        Point[] allPoints = new Point[coordinates.length / 2];

        int p = 0;
        for (int i = 0; i < coordinates.length; i += 2) {
            allPoints[p] = new Point(coordinates[i], coordinates[i + 1]);
            p++;
        }
        return allPoints;
    }

    public static void isHitToGraphic(Graphics[] graphics, Point[] points) {
        for (int i = 0; i < points.length; i++) {
            int conter = 0;
            for (int j = 0; j < graphics.length - 1; j++) {

                if (graphics[j].isHit(points[i].getX(), points[i].getY())) {
                    graphics[j].setPoints(points[i].getPoint(points[i]));
                } else {
                    conter++;
                }
                if (conter == 3) {
                    graphics[3].setPoints(points[i].getPoint(points[i]));
                }
            }
        }
        isDumpEmpty = false;
        System.out.println("Все точки добавлены в соответствующие группы");
    }

    public static void printPoints (Graphics[] graphics){
        for (int i = 0; i < graphics.length; i++) {
            if (graphics[i].getSize() == 0) {
                System.out.println("Группа " + (i+1) + " пуста.");
            } else if (i != 3){
                System.out.println("Группа " + (i+1) + ". Точки:");
                System.out.println(graphics[i].getPoints());
            } else {
                System.out.println("Количество точек не вошедших ни в одну группу: " + graphics[3].getSize());
            }
        }
    }

    public static void printGroupPoints (Graphics[] graphics, int[] groupNumber){
        Arrays.sort(groupNumber);
        for (int i = 0; i < groupNumber.length; i++) {
            int GNumber = groupNumber[i];
            if (graphics[GNumber - 1].getSize() == 0) {
                System.out.println("Группа " + GNumber + " пуста.");
            } else {
                System.out.println("Группа " + GNumber + ". Точки:");
                System.out.println(graphics[GNumber - 1].getPoints());
            }
        }
    }

    public static void removePoints (Graphics[] graphics, int[] groupNumber) {
        Arrays.sort(groupNumber);
            for (int i = 0; i < groupNumber.length; i++) {
                int GNumber = groupNumber[i];
                if (GNumber != 4){
                    graphics[GNumber - 1].clearPoints();
                }
            }
    }

    public static void removeAllPoints (Graphics[] graphics) {
        for (int i = 0; i < graphics.length; i++) {
            graphics[i].clearPoints();
        }
    }

    public static ArrayList getHelp() {
        ArrayList help = new ArrayList();
        help.add("add <point> - Добавить в память программы точки, координаты передаются парами чисел через пробел " +
                "пример: add 1 1 -2 -3 добавить 2 точки: (1,1) и (-2,-3)");
        help.add("\nprint - Напечатать построчно каждую из трех групп (входящие в них точки)");
        help.add("\nprint <group_num> - Напечатать одним списком точки, входящие в группу(ы) переданную(ые) параметром <group_num>" +
                " пример: print 1 2");
        help.add("\nremove <group_num> - Удалить из памяти все точки, входящие в группу(ы) <group_num>" +
                " прим. remove 2 3");
        help.add("\nclear - Очистить память");
        help.add("\nhelp - Вывод справки по командам");
        help.add("\nexit - Выход из программы");
         return help;
    }
}
