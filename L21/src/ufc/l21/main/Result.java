package ufc.l21.main

public enum Result {
    OK(0, "OK"),
    FILE_NOT_FOUND(1, "File Not Found"),
    IO_ERROR(2, "IO Error");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
