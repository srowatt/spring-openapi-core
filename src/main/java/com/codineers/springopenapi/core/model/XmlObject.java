package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * A metadata object that allows for more fine-tuned XML model definitions.
 *
 * When using arrays, XML element names are not inferred (for singular/plural forms) and the name property SHOULD be
 * used to add that information. See examples for expected behavior.
 */
public class XmlObject extends ExtensibleObject {
    /**
     * Replaces the name of the element/attribute used for the described schema property. When defined within items, it
     * will affect the name of the individual XML elements within the list. When defined alongside type being array
     * (outside the items), it will affect the wrapping element and only if wrapped is true. If wrapped is false, it
     * will be ignored.
     */
    private final String name;

    /**
     * The URI of the namespace definition. Value MUST be in the form of an absolute URI.
     */
    private final String namespace;

    /**
     * The prefix to be used for the name.
     */
    private final String prefix;

    /**
     * Declares whether the property definition translates to an attribute instead of an element. Default value is false.
     */
    private final boolean attribute;

    /**
     * MAY be used only for an array definition. Signifies whether the array is wrapped (for example,
     * <books><book/><book/></books>) or unwrapped (<book/><book/>). Default value is false. The definition takes effect
     * only when defined alongside type being array (outside the items).
     */
    private final boolean wrapped;

    private XmlObject(final String name, final String namespace, final String prefix, final boolean attribute,
                     final boolean wrapped, final Map<String, ?> extensions) {

        super(extensions);

        this.name = name;
        this.namespace = namespace;
        this.prefix = prefix;
        this.attribute = attribute;
        this.wrapped = wrapped;
    }

    public String getName() {
        return name;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAttribute() {
        return attribute;
    }

    public boolean isWrapped() {
        return wrapped;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String name;
        private String namespace;
        private String prefix;
        private boolean attribute;
        private boolean wrapped;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withNamespace(final String namespace) {
            this.namespace = namespace;
            return this;
        }

        public Builder withPrefix(final String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Builder withAttribute(final boolean attribute) {
            this.attribute = attribute;
            return this;
        }

        public Builder withWrapped(final boolean wrapped) {
            this.wrapped = wrapped;
            return this;
        }

        @Override
        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public XmlObject build() {
            return new XmlObject(name, namespace, prefix, attribute, wrapped, extensions);
        }
    }
}
