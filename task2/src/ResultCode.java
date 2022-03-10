public enum ResultCode {
    POINT_ON_CIRCLE(0), POINT_IN_CIRCLE(1), POINT_OUT_CIRCLE(2);

    private int messageCode;

    ResultCode(final int messageCode) {
        this.messageCode = messageCode;
    }
}
