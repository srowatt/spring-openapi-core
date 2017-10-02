package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * Describes a single operation parameter.
 * <p>
 * A unique parameter is defined by a combination of a name and location.
 * <p>
 * Parameter Locations
 * <p>
 * There are four possible parameter locations specified by the in field:
 * <p>
 * path - Used together with Path Templating, where the parameter value is actually part of the operation's URL. This
 * does not include the host or base path of the API. For example, in /items/{itemId}, the path parameter is itemId
 * <p>
 * query - Parameters that are appended to the URL. For example, in /items?id=###, the query parameter is id
 * <p>
 * header - Custom headers that are expected as part of the request. Note that RFC7230 states header names are case
 * insensitive.
 * <p>
 * cookie - Used to pass a specific cookie value to the API.
 */
public class ParameterObject extends ExtensibleObject {

    /**
     * The name of the parameter. Parameter names are case sensitive.
     * <p>
     * If in is "path", the name field MUST correspond to the associated path segment from the path field in the Paths
     * Object. See Path Templating for further information.
     * <p>
     * If in is "header" and the name field is "Accept", "Content-Type" or "Authorization", the parameter definition
     * SHALL be ignored.
     * <p>
     * For all other cases, the name corresponds to the parameter name used by the in property.
     */
    @NotBlank
    private final String name;

    /**
     * The location of the parameter. Possible values are "query", "header", "path" or "cookie".
     */
    @NotBlank
    private final String in;

    /**
     * A brief description of the parameter. This could contain examples of use. CommonMark syntax MAY be used for
     * rich text representation.
     */
    private final String description;

    /**
     * Determines whether this parameter is mandatory. If the parameter location is "path", this property is REQUIRED
     * and its value MUST be true. Otherwise, the property MAY be included and its default value is false.
     */
    private final boolean required;

    /**
     * Specifies that a parameter is deprecated and SHOULD be transitioned out of usage.
     */
    private final boolean deprecated;

    /**
     * Sets the ability to pass empty-valued parameters. This is valid only for query parameters and allows sending a
     * parameter with an empty value. Default value is false. If style is used, and if behavior is n/a (cannot be
     * serialized), the value of allowEmptyValue SHALL be ignored.
     */
    private final boolean allowEmptyValue;

    /**
     * Describes how the parameter value will be serialized depending on the type of the parameter value. Default
     * values (based on value of in): for query - form; for path - simple; for header - simple; for cookie - form.
     */
    private final String style;

    /**
     * When this is true, parameter values of type array or object generate separate parameters for each value of the
     * array or key-value pair of the map. For other types of parameters this property has no effect. When style is
     * form, the default value is true. For all other styles, the default value is false.
     */
    private final boolean explode;

    /**
     * Determines whether the parameter value SHOULD allow reserved characters, as defined by RFC3986
     * :/?#[]@!$&'()*+,;= to be included without percent-encoding. This property only applies to parameters with an in
     * value of query. The default value is false.
     */
    private final boolean allowReserved;

    /**
     * The schema defining the type used for the parameter.
     */
    private final Object/*SchemaObject | ReferenceObject*/ schema;

    /**
     * Example of the media type. The example SHOULD match the specified schema and encoding properties if present.
     * The example object is mutually exclusive of the examples object. Furthermore, if referencing a schema which
     * contains an example, the example value SHALL override the example provided by the schema. To represent examples
     * of media types that cannot naturally be represented in JSON or YAML, a string value can contain the example
     * with escaping where necessary.
     */
    private final Object /*Any*/ example;

    /**
     * Examples of the media type. Each example SHOULD contain a value in the correct format as specified in the
     * parameter encoding. The examples object is mutually exclusive of the example object. Furthermore, if referencing
     * a schema which contains an example, the examples value SHALL override the example provided by the schema.
     */
    private final Map<String, ? /*ExampleObject | ReferenceObject]*/> examples;

    /**
     * A map containing the representations for the parameter. The key is the media type and the value describes it.
     * The map MUST only contain one entry.
     */
    private final Map<String, MediaTypeObject> content;


    protected ParameterObject(final String name, final String in, final String description, final boolean required,
                              final boolean deprecated, final boolean allowEmptyValue, final String style,
                              final boolean explode, final boolean allowReserved, final Object schema,
                              final Object example, final Map<String, ?> examples,
                              final Map<String, MediaTypeObject> content, final Map<String, ?> extensions) {
        super(extensions);
        this.name = name;
        this.in = in;
        this.description = description;
        this.required = required;
        this.deprecated = deprecated;
        this.allowEmptyValue = allowEmptyValue;
        this.style = style;
        this.explode = explode;
        this.allowReserved = allowReserved;
        this.schema = schema;
        this.example = example;
        this.examples = examples;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getIn() {
        return in;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public boolean isAllowEmptyValue() {
        return allowEmptyValue;
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

    public Object getSchema() {
        return schema;
    }

    public Object getExample() {
        return example;
    }

    public Map<String, ?> getExamples() {
        return examples;
    }

    public Map<String, MediaTypeObject> getContent() {
        return content;
    }

    public static class Builder extends ExtensibleObject.Builder {
        protected String name;
        protected String in;
        protected String description;
        protected boolean required;
        protected boolean deprecated;
        protected boolean allowEmptyValue;
        protected String style;
        protected boolean explode;
        protected boolean allowReserved;
        protected Object/*SchemaObject | ReferenceObject*/ schema;
        protected Object /*Any*/ example;
        protected Map<String, ? /*ExampleObject | ReferenceObject]*/> examples;
        protected Map<String, MediaTypeObject> content;

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

        public ParameterObject build() {
            return new ParameterObject(name, in, description, required, deprecated, allowEmptyValue, style, explode,
                allowReserved, schema, example, examples, content, extensions);
        }
    }
}
