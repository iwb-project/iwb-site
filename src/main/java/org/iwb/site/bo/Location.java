package org.iwb.site.bo;

import org.springframework.data.annotation.Id;

/**
 * TODO document me
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class Location {

    @Id
    private String _id;

    private int zipCode;
    private String name;

    /**
     * Default constructor.
     */
    public Location() {
        // void
    }
    
    /**
     * Default constructor.
     * @param code
     * @param name
     */
    public Location(int code, String name) {
        this.zipCode = code;
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

    /**
     * Gets _id.
     *
     * @return Value of _id.
     */
    public String get_id() {
        return _id;
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
     * Sets new _id.
     *
     * @param _id New value of _id.
     */
    public void set_id(String _id) {
        this._id = _id;
    }
}
