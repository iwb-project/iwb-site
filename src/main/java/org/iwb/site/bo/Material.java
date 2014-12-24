package org.iwb.site.bo;

import org.springframework.data.annotation.Id;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
public class Material {

    @Id
    private String constant;

    private long version = 1L;

    private String description;

    /**
     * Default constructor.
     */
    public Material() {
        // void
    }

    public Material(String constant, String description) {
        this.constant = constant;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
