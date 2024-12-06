package fast.campus.netplix2.controller;

import fast.campus.netplix2.exception.ErrorCode;

public record NetplixApiResponse<T> (
        boolean success,
        String code,
        String message,
        T data
){
        public static final String CODE_SUCCEED = "SUCCEED";

        public static <T> NetplixApiResponse<T> ok(T data) {
            return new NetplixApiResponse<>(true, CODE_SUCCEED,null, data);
        }

        public static <T> NetplixApiResponse<T> fail(ErrorCode errorcode, String message) {
            return new NetplixApiResponse<>(false,errorcode.getCode(), message, null);
        }
}
