package com.example.base.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * @ControllerAdvice :
 *  - 전역 예외 처리 클래스
 *  - 모든 컨트롤러에서 발생하는 예외를 한 곳에서 처리 가능
 *
 * @ExceptionHandler :
 *  - 지정한 예외가 발생했을 때 해당 메서드로 처리
 *  - 파라미터로 예외 객체(Exception e 등)를 받을 수 있음
 *
 * HttpServletRequest : 클라이언트가 보낸 HTTP 요청의 메타데이터(요청 정보)
 */

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                500,
                "Internal Server Error",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(500).body(errorResponse);
    }

    @Getter @Setter
    public static class ErrorResponse {
        private int status;
        private String error;
        private String message;
        private String path;

        public ErrorResponse(int status, String error, String message, String path) {
            this.status = status;
            this.error = error;
            this.message = message;
            this.path = path;
        }
    }
}
