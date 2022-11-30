package bridge;

public enum Result {
    SUCCESS("성공"), FAIL("실패");

    private String result;

    Result(String result) {
        this.result = result;
    }
}
