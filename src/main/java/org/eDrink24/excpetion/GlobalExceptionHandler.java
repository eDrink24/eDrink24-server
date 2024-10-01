package org.eDrink24.excpetion;

import org.eDrink24.excpetion.NotEnoughStock.NotEnoughStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 주문 시, 오늘픽업 재고부족으로 인한 예외
    @ExceptionHandler(NotEnoughStockException.class)
    public ResponseEntity<String> notEnoughStockException(NotEnoughStockException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
