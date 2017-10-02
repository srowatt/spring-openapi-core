package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * The object provides metadata about the API. The metadata MAY be used by the clients if needed, and MAY be presented
 * in editing or documentation generation tools for convenience.
 */
@JsonDeserialize(builder = InfoObject.Builder.class)
public class InfoObject extends ExtensibleObject {
    /**
     * The title of the application.
     */
    @NotBlank
    private final String title;

    /**
     * A short description of the application. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * A URL to the Terms of Service for the API. MUST be in the format of a URL.
     */
    private final String termsOfService;

    /**
     * The contact information for the exposed API.
     */
    private final ContactObject contact;

    /**
     * The license information for the exposed API.
     */
    private final LicenseObject license;

    /**
     * The version of the OpenAPI document (which is distinct from the OpenAPI Specification version or the API implementation version).
     */
    @NotBlank
    private String version;

    private InfoObject(final String title, final String description, final String termsOfService,
                       final ContactObject contact, final LicenseObject license, final String version,
                       final Map<String, ?> extensions) {

        super(extensions);

        this.title = title;
        this.description = description;
        this.termsOfService = termsOfService;
        this.contact = contact;
        this.license = license;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public ContactObject getContact() {
        return contact;
    }

    public LicenseObject getLicense() {
        return license;
    }

    public String getVersion() {
        return version;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String title;
        private String description;
        private String termsOfService;
        private ContactObject contact;
        private LicenseObject license;
        private String version;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder withTitle(final String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withTermsOfService(final String termsOfService) {
            this.termsOfService = termsOfService;
            return this;
        }

        public Builder withContact(final ContactObject contact) {
            this.contact = contact;
            return this;
        }

        public Builder withLicense(final LicenseObject license) {
            this.license = license;
            return this;
        }

        public Builder withVersion(final String version) {
            this.version = version;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public Builder but() {
            return builder()
                .withExtensions(extensions)
                .withTitle(title)
                .withDescription(description)
                .withTermsOfService(termsOfService)
                .withContact(contact)
                .withLicense(license)
                .withVersion(version);
        }

        public InfoObject build() {
            return new InfoObject(title, description, termsOfService, contact, license, version, extensions);
        }
    }
}
