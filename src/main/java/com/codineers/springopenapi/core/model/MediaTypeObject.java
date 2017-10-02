package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * Each Media Type Object provides schema and examples for the media type identified by its key.
 */
public class MediaTypeObject extends ExtensibleObject {
    /**
     * The schema defining the type used for the request body.
     */
    private final Object/*Schema Object | Reference Object*/ schema;
    /**
     * Example of the media type. The example object SHOULD be in the correct format as specified by the media type.
     * The example object is mutually exclusive of the examples object. Furthermore, if referencing a schema which
     * contains an example, the example value SHALL override the example provided by the schema.
     */
    private final Object/*Any*/ example;

    /**
     * Examples of the media type. Each example object SHOULD match the media type and specified schema if present.
     * The examples object is mutually exclusive of the example object. Furthermore, if referencing a schema which
     * contains an example, the examples value SHALL override the example provided by the schema.
     */
    private final Map<String, ? /*ExampleObject | ReferenceObject*/> examples;

    /**
     * A map between a property name and its encoding information. The key, being the property name, MUST exist in the
     * schema as a property. The encoding object SHALL only apply to requestBody objects when the media type is
     * multipart or application/x-www-form-urlencoded.
     */
    private final Map<String, EncodingObject> encoding;

    private MediaTypeObject(final Object schema, final Object example, final Map<String, ?> examples,
                            final Map<String, EncodingObject> encoding, final Map<String, ?> extensions) {

        super(extensions);

        this.schema = schema;
        this.example = example;
        this.examples = examples;
        this.encoding = encoding;
    }

    public Object getSchema() {
        return schema;
    }

    public Object getExample() {
        return example;
    }

    public Map<String, ?> getExamples() {
        return examples;
    }

    public Map<String, EncodingObject> getEncoding() {
        return encoding;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private Object/*Schema Object | Reference Object*/ schema;
        private Object/*Any*/ example;
        private Map<String, ? /*ExampleObject | ReferenceObject*/> examples;
        private Map<String, EncodingObject> encoding;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withSchema(final Object/*Schema Object | Reference Object*/ schema) {
            this.schema = schema;
            return this;
        }

        public Builder withExample(final Object/*Any*/ example) {
            this.example = example;
            return this;
        }

        public Builder withExamples(final Map<String, ? /*ExampleObject | ReferenceObject*/> examples) {
            this.examples = examples;
            return this;
        }

        public Builder withEncoding(final Map<String, EncodingObject> encoding) {
            this.encoding = encoding;
            return this;
        }

        @Override
        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public MediaTypeObject build() {
            return new MediaTypeObject(schema, example, examples, encoding, extensions);
        }
    }
}
