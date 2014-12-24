package org.iwb.site.repository;

import org.iwb.site.bo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Manages the users.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface UserDao extends PagingAndSortingRepository<User, String> {

}
