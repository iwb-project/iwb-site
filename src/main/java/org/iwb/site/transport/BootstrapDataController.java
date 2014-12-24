package org.iwb.site.transport;

import org.iwb.site.bo.Material;
import org.iwb.site.bo.User;
import org.iwb.site.repository.MaterialDao;
import org.iwb.site.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO document me
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@RestController
public class BootstrapDataController {

    public static final String NON_RECYCLABLE = "NON-RECYCLABLE";
    public static final String COMPOST = "COMPOST";
    public static final String PLASTIC = "PLASTIC";
    public static final String TOXIC = "TOXIC";
    public static final String MEDICAL = "MEDICAL";
    public static final String GLASS = "GLASS";
    public static final String TEXTILE = "TEXTILE";
    public static final String PAPER = "PAPER";
    public static final String CARTON = "CARTON";
    public static final String ELECTRONIC = "ELECTRONIC";
    public static final String FURNITURE = "FURNITURE";
    public static final String METAL = "METAL";
    public static final String WOOD = "WOOD";

    @Autowired
    private UserDao userDao;

    @Autowired
    private MaterialDao materialDao;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    private SaltSource saltSource;

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public Map<String, Long> bootstrap() {
        Map<String, Long> result = new HashMap<>();
        this.userDao.save(users());
        result.put("users", this.userDao.count());

        this.materialDao.save(materials());
        result.put("materials", this.materialDao.count());

        return result;
    }

    private List<Material> materials() {
        return Arrays.asList(new Material(NON_RECYCLABLE, "Déchet non recyclable"),
                new Material(COMPOST, "Déchet végétal"),
                new Material(PLASTIC, "Plastique recyclable"),
                new Material(TOXIC, "Déchet toxic"),
                new Material(MEDICAL, "Déchet médical"),
                new Material(GLASS, "Verre"),
                new Material(TEXTILE, "Déchet textile"),
                new Material(PAPER, "Papier"),
                new Material(CARTON, "Carton"),
                new Material(ELECTRONIC, "Déchet electronique"),
                new Material(FURNITURE, "Déchet végétaux"),
                new Material(METAL, "Métaux"),
                new Material(WOOD, "Bois"));
    }

    private User user(final String name, final String... roles) {
        User user = new User();
        user.setId(name);
        user.setName(name);
        user.setPassword(this.passwordEncoder.encodePassword("password", this.saltSource.getSalt(user)));
        user.setEmail(name + "@iwb.org");

        user.setAuthorities(
                Arrays.stream(roles).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        return user;
    }

    private List<User> users() {
        return Arrays.asList(
                user("admin", "administrator", "user"),
                user("user", "user")
        );

    }

    @RequestMapping(value = "/bootstrap/delete", method = RequestMethod.GET)
    @Secured("administrator")
    public Map<String, Long> cleanup(Principal principal) {
        Map<String, Long> result = new HashMap<>();

        Map<String, CrudRepository<?, ?>> repositories = new HashMap<>();
        repositories.put("users", this.userDao);
        repositories.put("materials", this.materialDao);

        repositories.forEach((k, v) -> {
            v.deleteAll();
            result.put(k, v.count());
        });

        return result;
    }
}
