package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * A single encoding definition applied to a single schema property.
 */
public class EncodingObject extends ExtensibleObject {
    /**
     * The Content-Type for encoding a specific property. Default value depends on the property type: for string with
     * format being binary – application/octet-stream; for other primitive types – text/plain;
     * for object - application/json; for array – the default is defined based on the inner type. The value can be a
     * specific media type (e.g. application/json), a wildcard media type (e.g. image/*), or a comma-separated list of
     * the two types.
     */
    private final String contentType;

    /**
     * A map allowing additional information to be provided as headers, for example Content-Disposition. Content-Type
     * is described separately and SHALL be ignored in this section. This property SHALL be ignored if the request body
     * media type is not a multipart.
     */
    private final Map<String, ? /*HeaderObject | ReferenceObject*/> headers;

    /**
     * Describes how a specific property value will be serialized depending on its type. See Parameter Object for
     * details on the style property. The behavior follows the same values as query parameters, including default
     * values. This property SHALL be ignored if the request body media type is not application/x-www-form-urlencoded.
     */
    private final String style;

    /**
     * When this is true, property values of type array or object generate separate parameters for each value of the
     * array, or key-value-pair of the map. For other types of properties this property has no effect. When style is
     * form, the default value is true. For all other styles, the default value is false. This property SHALL be
     * ignored if the request body media type is not application/x-www-form-urlencoded.
     */
    private final boolean explode;

    /**
     * Determines whether the parameter value SHOULD allow reserved characters, as defined by
     * RFC3986 :/?#[]@!$&'()*+,;= to be included without percent-encoding. The default value is false. This property
     * SHALL be ignored if the request body media type is not application/x-www-form-urlencoded.
     */
    private final boolean allowReserved;

    private EncodingObject(final String contentType, final Map<String, ?> headers, final String style,
                           final boolean explode, final boolean allowReserved, final Map<String, ?> extensions) {
        super(extensions);
        this.contentType = contentType;
        this.headers = headers;
        this.style = style;
        this.explode = explode;
        this.allowReserved = allowReserved;
    }

    public String getContentType() {
        return contentType;
    }

    public Map<String, ?> getHeaders() {
        return headers;
    }

    public String getStyle() {
        return style;
    }

    public boolean isExplode() {
        return explode;
    }

    public boolean isAllowReserved() {
        return allowReserved;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private String contentType;
        private Map<String, ? /*HeaderObject | ReferenceObject*/> headers;
        private String style;
        private boolean explode;
        private boolean allowReserved;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withContentType(final String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder withHeaders(final Map<String, ?> headers) {
            this.headers = headers;
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

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public EncodingObject build() {
            return new EncodingObject(contentType, headers, style, explode, allowReserved, extensions);
        }
    }
}
