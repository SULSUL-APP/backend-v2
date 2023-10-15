package com.sulsul.api.exception.essay;

import com.sulsul.api.exception.BadInputException;

import java.util.Map;

public class InvalidEssayCreateException extends BadInputException {
    public InvalidEssayCreateException(Map<String, String> errors) {
        super("ESSAY_01", "첨삭 생성에 실패했습니다.", errors);
    }
}