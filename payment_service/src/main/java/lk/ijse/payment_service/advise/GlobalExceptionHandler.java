package lk.ijse.payment_service.advise;


import lk.ijse.payment_service.service.exception.DuplicateRecordException;
import lk.ijse.payment_service.service.exception.NotFoundException;
import lk.ijse.payment_service.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Map<String,Object>> handleServiceException(ServiceException exp){
        Map<String, Object> commonErrorAttribute;
        if (exp instanceof DuplicateRecordException){
            commonErrorAttribute = getCommonErrorAttribute(HttpStatus.CONFLICT);
        }
        else if (exp instanceof NotFoundException){
            commonErrorAttribute = getCommonErrorAttribute(HttpStatus.NOT_FOUND);
        }

        else {
            commonErrorAttribute=getCommonErrorAttribute(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        commonErrorAttribute.put("message",exp.getMessage());

        return new ResponseEntity<>(commonErrorAttribute,HttpStatus.valueOf((Integer) commonErrorAttribute.get("code")));
    }


    public Map<String,Object> getCommonErrorAttribute(HttpStatus status){
        LinkedHashMap<String, Object> errAttribute = new LinkedHashMap<>();
        errAttribute.put("code",status.value());
        errAttribute.put("status",status);
        return errAttribute;

    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,Object> handleDataValidationException(MethodArgumentNotValidException exp){
        Map<String, Object> commonErrorAttribute = getCommonErrorAttribute(HttpStatus.BAD_REQUEST);
        ArrayList<Map<String,Object>> errorList=new ArrayList<>();

        for (FieldError fieldError : exp.getFieldErrors()) {
            LinkedHashMap<String, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
            objectObjectLinkedHashMap.put("field",fieldError.getField());
            objectObjectLinkedHashMap.put("message",fieldError.getDefaultMessage());
            objectObjectLinkedHashMap.put("rejected",fieldError.getRejectedValue());
            errorList.add(objectObjectLinkedHashMap);

        }
        commonErrorAttribute.put("message","data validation failed");
        commonErrorAttribute.put("error",errorList);
        return commonErrorAttribute;
    }
}
