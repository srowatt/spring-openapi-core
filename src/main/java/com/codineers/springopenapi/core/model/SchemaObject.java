package com.codineers.springopenapi.core.model;

import java.util.Map;

public class SchemaObject extends ExtensibleObject {
    /**
     * Allows sending a null value for the defined schema. Default value is false.
     */
    private final boolean nullable;

    /**
     * Adds support for polymorphism. The discriminator is an object name that is used to differentiate between other
     * schemas which may satisfy the payload description. See Composition and Inheritance for more details.
     */
    private final DiscriminatorObject discriminator;

    /**
     * Relevant only for Schema "properties" definitions. Declares the property as "read only". This means that it MAY
     * be sent as part of a response but SHOULD NOT be sent as part of the request. If the property is marked as
     * readOnly being true and is in the required list, the required will take effect on the response only. A property
     * MUST NOT be marked as both readOnly and writeOnly being true. Default value is false.
     */
    private final boolean readOnly;

    /**
     * Relevant only for Schema "properties" definitions. Declares the property as "write only". Therefore, it MAY be
     * sent as part of a request but SHOULD NOT be sent as part of the response. If the property is marked as writeOnly
     * being true and is in the required list, the required will take effect on the request only. A property MUST NOT
     * be marked as both readOnly and writeOnly being true. Default value is false.
     */
    private final boolean writeOnly;

    /**
     * This MAY be used only on properties schemas. It has no effect on root schemas. Adds additional metadata to
     * describe the XML representation of this property.
     */
    private final XmlObject xml;

    /**
     * Additional external documentation for this schema.
     */
    private final ExternalDocumentationObject externalDocs;

    /**
     * A free-form property to include an example of an instance for this schema. To represent examples that cannot be
     * naturally represented in JSON or YAML, a string value can be used to contain the example with escaping where
     * necessary.
     */
    private final Object/*Any*/ example;

    /**
     * Specifies that a schema is deprecated and SHOULD be transitioned out of usage. Default value is false.
     */
    private final boolean deprecated;

    private SchemaObject(final boolean nullable, final DiscriminatorObject discriminator, final boolean readOnly,
                         final boolean writeOnly, final XmlObject xml, final ExternalDocumentationObject externalDocs,
                         final Object example, final boolean deprecated, final Map<String, ?> extensions) {

        super(extensions);

        this.nullable = nullable;
        this.discriminator = discriminator;
        this.readOnly = readOnly;
        this.writeOnly = writeOnly;
        this.xml = xml;
        this.externalDocs = externalDocs;
        this.example = example;
        this.deprecated = deprecated;
    }

    public boolean isNullable() {
        return nullable;
    }

    public DiscriminatorObject getDiscriminator() {
        return discriminator;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public boolean isWriteOnly() {
        return writeOnly;
    }

    public XmlObject getXml() {
        return xml;
    }

    public ExternalDocumentationObject getExternalDocs() {
        return externalDocs;
    }

    public Object getExample() {
        return example;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private boolean nullable;
        private DiscriminatorObject discriminator;
        private boolean readOnly;
        private boolean writeOnly;
        private XmlObject xml;
        private ExternalDocumentationObject externalDocs;
        private Object/*Any*/ example;
        private boolean deprecated;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withNullable(final boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public Builder withDiscriminator(final DiscriminatorObject discriminator) {
            this.discriminator = discriminator;
            return this;
        }

        public Builder withReadOnly(final boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public Builder withWriteOnly(final boolean writeOnly) {
            this.writeOnly = writeOnly;
            return this;
        }

        public Builder withXml(final XmlObject xml) {
            this.xml = xml;
            return this;
        }

        public Builder withExternalDocs(final ExternalDocumentationObject externalDocs) {
            this.externalDocs = externalDocs;
            return this;
        }

        public Builder withExample(final Object example) {
            this.example = example;
            return this;
        }

        public Builder withDeprecated(final boolean deprecated) {
            this.deprecated = deprecated;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public SchemaObject build() {
            return new SchemaObject(nullable, discriminator, readOnly, writeOnly, xml, externalDocs, example,
                deprecated, extensions);
        }
    }
}
