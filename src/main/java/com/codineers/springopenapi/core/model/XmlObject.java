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
    private String name;

    /**
     * The URI of the namespace definition. Value MUST be in the form of an absolute URI.
     */
    private String namespace;

    /**
     * The prefix to be used for the name.
     */
    private String prefix;

    /**
     * Declares whether the property definition translates to an attribute instead of an element. Default value is false.
     */
    private boolean attribute;

    /**
     * MAY be used only for an array definition. Signifies whether the array is wrapped (for example,
     * <books><book/><book/></books>) or unwrapped (<book/><book/>). Default value is false. The definition takes effect
     * only when defined alongside type being array (outside the items).
     */
    private boolean wrapped;

    public XmlObject(Map<String, ?> extensions, String name, String namespace, String prefix, boolean attribute, boolean wrapped) {
        super(extensions);
        this.name = name;
        this.namespace = namespace;
        this.prefix = prefix;
        this.attribute = attribute;
        this.wrapped = wrapped;
    }
}
