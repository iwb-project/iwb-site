package org.iwb.site.bo;

import org.springframework.data.annotation.Id;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
public class Sequence {

    @Id
    private String name;
    private Long counter;

    /**
     * Default constructor.
     */
    public Sequence() {
        // void
    }

    public Sequence(final String name, final Long counter) {
        this.name = name;
        this.counter = counter;
    }

    public String getName() {
        return this.name;
    }

    public Long getCounter() {
        return this.counter;
    }

    public void setCounter(final Long counter) {
        this.counter = counter;
    }

}
