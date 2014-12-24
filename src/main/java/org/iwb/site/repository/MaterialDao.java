package org.iwb.site.repository;

import org.iwb.site.bo.Material;
import org.iwb.site.bo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TODO document me
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface MaterialDao extends PagingAndSortingRepository<Material, String> {
}
