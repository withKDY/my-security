package com.project.bns.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FAILED("9999", "Unexpected Error", null);

    private static final Map<String, ErrorCode> errorMap =
            Arrays.stream(values()).collect(Collectors.toMap(ErrorCode::getCode, e->e));

    public static ErrorCode findByCode(String code) {
        return errorMap.get(code);
    }

    private String code;
    private String errorMessage;
    private String url;

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String>getErrorMap() {
        return new HashMap<>(){{
            put("code", code);
            put("massage", errorMessage);
        }};
    }

    public String getErrorString() {
        return getErrorJson().toString();
    }

    public JSONObject getErrorJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", code);
            jsonObject.put("message", errorMessage);
        }
        catch (JSONException ignore) {}
        return jsonObject;
    }

    public String getCustomErrorCodeStr() {
        return "ERROR_CODE_" + this.code;
    }
}
