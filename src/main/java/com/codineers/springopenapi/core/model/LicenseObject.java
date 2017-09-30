package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * License information for the exposed API.
 */
public class LicenseObject extends ExtensibleObject {
    /**
     * The license name used for the API.
     */
    @NotBlank
    private final String name;

    /**
     * A URL to the license used for the API. MUST be in the format of a URL.
     */
    private final String url;

    private LicenseObject(@NotBlank final String name, final String url, final Map<String, ?> extensions) {
        super(extensions);

        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String name;
        private String url;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public Builder but() {
            return builder()
                    .withExtensions(extensions)
                    .withName(name)
                    .withUrl(url);
        }

        public LicenseObject build() {
            return new LicenseObject(name, url, extensions);
        }
    }
}
