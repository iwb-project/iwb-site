package org.iwb.site.bo;

import org.springframework.data.annotation.Id;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
public class Trash {

    @Id
    private Long id;

    private String name;

    private String snippet;

    /**
     * Default constructor.
     */
    public Trash() {
        // void
    }

    public Trash(final String name, final String snippet) {
        this.name = name;
        this.snippet = snippet;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Sets new snippet.
     *
     * @param snippet New value of snippet.
     */
    public void setSnippet(final String snippet) {
        this.snippet = snippet;
    }

    /**
     * Gets snippet.
     *
     * @return Value of snippet.
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }
}
