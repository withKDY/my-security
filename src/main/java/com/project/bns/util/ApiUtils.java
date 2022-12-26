package com.project.bns.util;

import com.project.bns.errors.ErrorCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApiUtils {
    public static <T> ApiResult<T> success(T body) {
        return new ApiResult<>(true, body, null);
    }

    public static ApiResult<?> error(ErrorCode errCode) {
        return new ApiResult<>(false, null, new ApiError(errCode));
    }

    public static ApiResult<?> error(String errCode, String errMessage) {
        return new ApiResult<>(false, null, new ApiError(errCode, errMessage));
    }

    public static class ApiError {

        private final String errCode;
        private final String errMessage;

        ApiError(ErrorCode errCode) {
            this.errCode = errCode.getCode();
            this.errMessage = errCode.getErrorMessage();
        }

        public ApiError(String errCode, String errMessage) {
            this.errCode = errCode;
            this.errMessage = errMessage;
        }

        public String getErrCode() {
            return errCode;
        }

        public String getErrMessage() {
            return errMessage;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("errCode", errCode)
                    .append("errMessage", errMessage)
                    .toString();
        }
    }

    public static class ApiResult<T> {
        private final boolean success;

        private final T data;

        private final ApiError error;

        public ApiResult(boolean success, T data, ApiError error) {
            this.success = success;
            this.data = data;
            this.error = error;
        }

        public boolean isSuccess() {
            return success;
        }

        public T getData() {
            return data;
        }

        public ApiError getError() {
            return error;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("success", success)
                    .append("data", data)
                    .append("error", error)
                    .toString();
        }
    }
}
