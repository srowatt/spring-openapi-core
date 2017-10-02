package com.codineers.springopenapi.sample.complete.model;

public class ResponseWrapper<T extends ModelBase> {
    private final String code;
    private final String description;
    private final T response;

    private ResponseWrapper(final String code, final String description, final T response) {
        this.code = code;
        this.description = description;
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public T getResponse() {
        return response;
    }

    public static final class Builder<T extends ModelBase> {
        private String code;
        private String description;
        private T response;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withCode(final String code) {
            this.code = code;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withResponse(final T response) {
            this.response = response;
            return this;
        }

        public ResponseWrapper<T> build() {
            return new ResponseWrapper<>(code, description, response);
        }
    }
}
