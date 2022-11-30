package bridge;

public enum CrossChecker {
    SUCCESS("O"), FAIL("X");

    private String result;

    CrossChecker(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public static boolean isFail(CrossChecker checker) {
        return checker == CrossChecker.FAIL;
    }
}
