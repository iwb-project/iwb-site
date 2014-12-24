package org.iwb.site.transport;

import com.mongodb.BasicDBObject;
import org.iwb.site.bo.Item;
import org.iwb.site.bo.ItemEssentials;
import org.iwb.site.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * TODO: document me.
 *
 * @author mathieu.pousse@zenika.com
 */
@RestController
@RequestMapping(value = "/items")
public class ItemResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemResources.class);

    @Autowired
    private ItemService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<ItemEssentials> listItems() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Iterable<ItemEssentials> searchItems(@RequestParam("q") String query) {
        LOGGER.debug("searching for {}", query);
        return this.service.search(query);
    }


    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
    public Item findItemById(@PathVariable("itemId") final Long itemId) {
        return this.service.findItemById(itemId);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Item item) {
        try {
            Item saved = this.service.save(item);
            return new BasicDBObject("error", null).append("itemId", saved.getId()).toMap();
        } catch (Exception any) {
            return new BasicDBObject("error", any.getClass() + " - " + any.getMessage()).toMap();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, Object> create(@RequestBody Item item) {
        return update(item);
    }

}
