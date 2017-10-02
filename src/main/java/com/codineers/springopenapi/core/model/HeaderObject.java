package com.codineers.springopenapi.core.model;

import java.util.Map;

public class HeaderObject extends ParameterObject {

    private HeaderObject(final String name, final String in, final String description, final boolean required,
                         final boolean deprecated, final boolean allowEmptyValue, final String style,
                         final boolean explode, final boolean allowReserved, final Object schema,
                         final Object example, final Map<String, ?> examples,
                         final Map<String, MediaTypeObject> content, final Map<String, ?> extensions) {

        super(name, in, description, required, deprecated, allowEmptyValue, style, explode,
            allowReserved, schema, example, examples, content, extensions);
    }

    public static final class Builder extends ParameterObject.Builder {

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withIn(final String in) {
            this.in = in;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withRequired(final boolean required) {
            this.required = required;
            return this;
        }

        public Builder withDeprecated(final boolean deprecated) {
            this.deprecated = deprecated;
            return this;
        }

        public Builder withAllowEmptyValue(final boolean allowEmptyValue) {
            this.allowEmptyValue = allowEmptyValue;
            return this;
        }

        public Builder withStyle(final String style) {
            this.style = style;
            return this;
        }

        public Builder withExplode(final boolean explode) {
            this.explode = explode;
            return this;
        }

        public Builder withAllowReserved(final boolean allowReserved) {
            this.allowReserved = allowReserved;
            return this;
        }

        public Builder withSchema(final Object schema) {
            this.schema = schema;
            return this;
        }

        public Builder withExample(final Object example) {
            this.example = example;
            return this;
        }

        public Builder withExamples(final Map<String, ?> examples) {
            this.examples = examples;
            return this;
        }

        public Builder withContent(final Map<String, MediaTypeObject> content) {
            this.content = content;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public HeaderObject build() {
            return new HeaderObject(name, in, description, required, deprecated, allowEmptyValue, style, explode,
                allowReserved, schema, example, examples, content, extensions);
        }
    }
}
