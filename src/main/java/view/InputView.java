package view;

import view.constant.Sign;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String BLANK = "";
    private static final String SPACE = " ";
    public static final String POSITIVE_INTEGER_ERROR_MESSAGE = "정수를 입력해주세요.";
    public static final String SEPARATOR_REQUIRED_ERROR_MESSAGE = Sign.COMMA.getShape() + "로 이름을 구분해주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        String input = input();

        validateSeparatorShape(input);
        return getSeparated(input);
    }

    public static int getHeight() {
        int input;

        try {
            input = Integer.parseInt(input());
            validatePositiveInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE);
        }
        return input;
    }

    private static void validatePositiveInteger(final int input) {
        if (input < 1) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    private static List<String> getSeparated(final String input) {
        return List.of(removeSpace(input).split(Sign.COMMA.getShape()));
    }

    private static String removeSpace(final String input) {
        return input.replace(SPACE, BLANK);
    }

    private static String input() {
        return scanner.nextLine();
    }

    private static void validateSeparatorShape(final String input) {
        if (!input.contains(Sign.COMMA.getShape())) {
            throw new IllegalArgumentException(SEPARATOR_REQUIRED_ERROR_MESSAGE);
        }
    }
}
