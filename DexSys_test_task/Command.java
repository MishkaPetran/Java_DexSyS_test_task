import java.util.Arrays;

public class Command {
    String[] expression;
    String command;
    int[] subcommand;

    public Command(String[] expression) {
        this.expression = expression;
        if (expression.length > 1) {
            this.command = expression[0];
            this.subcommand = toIntArray(expression[1].split(" "));
        } else {
            this.command = expression[0];
            this.subcommand = new int[]{};
        }

    }

    @Override
    public String toString() {
        return "Command{" +
                "subcommand=" + Arrays.toString(subcommand) +
                '}';
    }

    public String doCommand() {
        String returnable = "";
        switch (this.command) {
            case ("add"):
                returnable = "add";
                if ((this.subcommand.length > 1) && (this.subcommand[0] == 0)) {
                    System.out.println("Введены не корректные данные");
                    return returnable;
                } else if (this.subcommand.length % 2 != 0) {
                    System.out.println("Введенные данные не удоавлетворяют заданому формату. Вы ввели нечетное количество цифр");
                }
                return returnable;

            case ("print"):
                returnable = "print";
                return returnable;

            case ("remove"):
                returnable = "remove";
                return returnable;

            case ("clear"):
                returnable = "clear";
                return returnable;

            case ("help"):
                returnable = "help";
                return returnable;

            case ("exit"):
                returnable = "exit";
                return returnable;

            default:
                System.out.println("Команда не распознана. Введите help для вызова списка команд");
                return returnable;
        }
    }

    public int[] toIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < intArray.length; i++) {
            try {
                intArray[i] = Integer.parseInt(stringArray[i]);
            } catch (NumberFormatException e) {
                System.out.println("Введенные данные не удоавлетворяют заданому формату. Одно из введенных значений - не число");
            } catch (NullPointerException e) {
                System.out.println("Введены не корректные данные!");
            }
        }
        return intArray;
    }

    public String[] getExpression() {
        return expression;
    }

    public String getCommand() {
        return command;
    }

    public int[] getSubcommand() {
        return subcommand;
    }
}
