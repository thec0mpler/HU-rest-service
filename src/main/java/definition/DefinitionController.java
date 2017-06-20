package definition;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DefinitionController {
    private final AtomicLong counter = new AtomicLong();
    private List<Definition> definitions = new ArrayList<>();

    @RequestMapping(value = "/definitions/{id}", method = RequestMethod.GET)
    public Definition getDefinition(@PathVariable("id") long id) {
        // Check if definition exist and return it
        for (Definition definition : definitions) {
            if (id == definition.getId()) {
                return definition;
            }
        }

        return null;
    }

    @RequestMapping(value = "/definitions", method = RequestMethod.POST)
    public Definition postDefinition(@RequestBody Definition newDefinition) {
        // Update counter
        newDefinition.setId(counter.incrementAndGet());

        // Add definition
        definitions.add(newDefinition);

        return newDefinition;
    }

    @RequestMapping(value = "/definitions/{id}", method = RequestMethod.PUT)
    public Definition putDefinition(@PathVariable("id") long id, @RequestBody Definition newDefinition) {
        // Make sure the new definition has a id for comparing
        newDefinition.setId(id);

        // A definition if id already exists, otherwise null
        Definition definition = this.getDefinition(id);

        if (null == definition) {
            // Add definition
            definitions.add(newDefinition);
        } else {
            // Update definition
            definitions.set(definitions.indexOf(definition), newDefinition);
        }

        return newDefinition;
    }

    // @TODO ...
    @RequestMapping(value = "/definitions/{id}", method = RequestMethod.PUT)
    public Definition patchDefinition(@PathVariable("id") long id, @RequestBody Definition newDefinition) {
        // Make sure the new definition has a id for comparing
        newDefinition.setId(id);

        // A definition if id already exists, otherwise null
        Definition definition = this.getDefinition(id);

        if (null == definition) {
            // Add definition
            definitions.add(newDefinition);
        } else {
            // Update definition
            definitions.set(definitions.indexOf(definition), newDefinition);
        }

        return newDefinition;
    }

    @RequestMapping(value = "/definitions/{id}", method = RequestMethod.DELETE)
    public boolean deleteDefinition(@PathVariable("id") long id) {
        // A definition if id already exists, otherwise null
        Definition definition = this.getDefinition(id);

        return definitions.remove(definition);
    }
}
