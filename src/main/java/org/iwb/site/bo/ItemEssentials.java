package org.iwb.site.bo;

import org.springframework.data.annotation.Id;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
public class ItemEssentials {

    @Id
    private Long id;

    private String name;

    /**
     * Default constructor.
     */
    public ItemEssentials() {
        // void
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
