package com.codineers.springopenapi.core.model;

import java.util.Map;

public class PathsObject extends ExtensibleObject {
    /**
     * A relative path to an individual endpoint. The field name MUST begin with a slash. The path is appended (no
     * relative URL resolution) to the expanded URL from the Server Object's url field in order to construct the full
     * URL. Path templating is allowed. When matching URLs, concrete (non-templated) paths would be matched before their
     * templated counterparts. Templated paths with the same hierarchy but different templated names MUST NOT exist as
     * they are identical. In case of ambiguous matching, it's up to the tooling to decide which one to use.
     */
    private final PathItemObject path;

    public PathsObject(final PathItemObject path, final Map<String, ?> extensions) {
        super(extensions);

        this.path = path;
    }

    public PathItemObject getPath() {
        return path;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private PathItemObject path;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withPath(final PathItemObject path) {
            this.path = path;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public PathsObject build() {
            return new PathsObject(path, extensions);
        }
    }
}
