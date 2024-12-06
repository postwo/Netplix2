package fast.campus.netplix2.exception;

import lombok.Getter;

import static fast.campus.netplix2.exception.ErrorCode.USER_ALREADY_EXIST;
import static fast.campus.netplix2.exception.ErrorCode.USER_DOES_NOT_EXIST;

@Getter
public class UserException extends RuntimeException{
    private final ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public static class UserDoseNotExistException extends UserException{
        public UserDoseNotExistException() {
            super(USER_DOES_NOT_EXIST);
        }
    }

    public static class UserAlreadyExistException extends UserException {
        public UserAlreadyExistException() {
            super(USER_ALREADY_EXIST);
        }
    }
}
