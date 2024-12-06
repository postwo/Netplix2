package fast.campus.netplix2.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private final ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public static class UserDoseNotExistException extends UserException{
        public UserDoseNotExistException() {
            super(ErrorCode.USER_DOES_NOT_EXIST);
        }
    }
}
