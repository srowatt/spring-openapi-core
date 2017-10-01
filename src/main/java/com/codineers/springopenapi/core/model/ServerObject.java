package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import java.util.Map;

public class ServerObject extends ExtensibleObject {
    /**
     * A URL to the target host. This URL supports Server Variables and MAY be relative, to indicate that the host
     * location is relative to the location where the OpenAPI document is being served. Variable substitutions will be
     * made when a variable is named in {brackets}.A URL to the target host. This URL supports Server Variables and MAY
     * be relative, to indicate that the host location is relative to the location where the OpenAPI document is being
     * served. Variable substitutions will be made when a variable is named in {brackets}.
     */
    @NotBlank
    private final String url;

    /**
     * An optional string describing the host designated by the URL. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * A map between a variable name and its value. The value is used for substitution in the server's URL template.
     */
    private final Map<String, ServerVariableObject> variables;

    private ServerObject(final String url, String description, final Map<String, ServerVariableObject> variables,
                        final Map<String, ?> extensions) {

        super(extensions);

        this.url = url;
        this.description = description;
        this.variables = variables;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, ServerVariableObject> getVariables() {
        return variables;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String url;
        private String description;
        private Map<String, ServerVariableObject> variables;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withVariables(final Map<String, ServerVariableObject> variables) {
            this.variables = variables;
            return this;
        }

        @Override
        public Builder withExtensions(Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ServerObject build() {
            return new ServerObject(url, description, variables, extensions);
        }
    }
}
