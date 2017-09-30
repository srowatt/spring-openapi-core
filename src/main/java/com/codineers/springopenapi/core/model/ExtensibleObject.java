package com.codineers.springopenapi.core.model;

import java.util.Map;

public class ExtensibleObject {
    protected final Map<String, ?> extensions;

    protected ExtensibleObject(Map<String, ?> extensions) {
        this.extensions = extensions;
    }

    public Map<String, ?> getExtensions() {
        return extensions;
    }

    public static class Builder {
        protected Map<String, ?> extensions;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ExtensibleObject build() {
            return new ExtensibleObject(extensions);
        }
    }
}
