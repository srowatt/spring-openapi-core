package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

/**
 * Contact information for the exposed API.
 */
@JsonDeserialize(builder = ContactObject.Builder.class)
public class ContactObject extends ExtensibleObject {
    /**
     * The identifying name of the contact person/organization.
     */
    private final String name;

    /**
     * The URL pointing to the contact information. MUST be in the format of a URL.
     */
    private final String url;

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    private final String email;

    private ContactObject(final String name, final String url, final String email, final Map<String, ?> extensions) {
        super(extensions);

        this.name = name;
        this.url = url;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String name;
        private String url;
        private String email;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Builder withEmail(final String email) {
            this.email = email;
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
                    .withUrl(url)
                    .withEmail(email);
        }

        public ContactObject build() {
            return new ContactObject(name, url, email, extensions);
        }
    }
}
