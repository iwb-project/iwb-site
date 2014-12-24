package org.iwb.site.bo;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
public class SecondLife {

    private Long trashId;

    private String materialId;

    /**
     * Default constructor.
     */
    public SecondLife() {
        // void
    }

    public SecondLife(final String materialId, final Long trashId) {
        this.materialId = materialId;
        this.trashId = trashId;
    }

    /**
     * Gets materialId.
     *
     * @return Value of materialId.
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * Sets new materialId.
     *
     * @param materialId New value of materialId.
     */
    public void setMaterialId(final String materialId) {
        this.materialId = materialId;
    }

    /**
     * Gets trashId.
     *
     * @return Value of trashId.
     */
    public Long getTrashId() {
        return trashId;
    }

    /**
     * Sets new trashId.
     *
     * @param trashId New value of trashId.
     */
    public void setTrashId(final Long trashId) {
        this.trashId = trashId;
    }
}
