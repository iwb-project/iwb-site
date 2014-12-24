package org.iwb.site.bo;

import java.util.List;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
public class Item extends ItemEssentials {

    private String description;

    private String barcode;

    private String manufacturer;

    private String materialId;

    private Material material;

    private Long views = 1L;

    private String authorId;

    private String lastEditAuthorId;

    private List<Component> components;

    private Trash trash;

    private long version;

    /**
     * Default constructor.
     */
    public Item() {
        // void
    }

    public Long getViews() {
        return this.views;
    }

    public void setViews(final Long views) {
        this.views = views;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(final String authorId) {
        this.authorId = authorId;
    }

    public String getLastEditAuthorId() {
        return this.lastEditAuthorId;
    }

    public void setLastEditAuthorId(final String lastEditAuthorId) {
        this.lastEditAuthorId = lastEditAuthorId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    /**
     * Gets barcode.
     *
     * @return Value of barcode.
     */
    public String getBarcode() {
        return this.barcode;
    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets new description.
     *
     * @param description New value of description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets new barcode.
     *
     * @param barcode New value of barcode.
     */
    public void setBarcode(final String barcode) {
        this.barcode = barcode;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

    public List<Component> getComponents() {
        return this.components;
    }

    public void setComponents(final List<Component> components) {
        this.components = components;
    }

    /**
     * Sets new trash.
     *
     * @param trash New value of trash.
     */
    public void setTrash(Trash trash) {
        this.trash = trash;
    }

    /**
     * Gets trash.
     *
     * @return Value of trash.
     */
    public Trash getTrash() {
        return trash;
    }

    /**
     * Sets new manufacturer.
     *
     * @param manufacturer New value of manufacturer.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets manufacturer.
     *
     * @return Value of manufacturer.
     */
    public String getManufacturer() {
        return manufacturer;
    }
}
