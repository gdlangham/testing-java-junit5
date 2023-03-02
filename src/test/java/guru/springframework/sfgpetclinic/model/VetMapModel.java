package guru.springframework.sfgpetclinic.model;

import java.util.HashMap;
import java.util.Map;

import guru.springframework.sfgpetclinic.fauxspring.Model;

public class VetMapModel implements Model {
    Map<String, Object> vetMap = new HashMap<>();
    @Override
    public void addAttribute(final String key, final Object o) {
        vetMap.put(key, o);
    }

    @Override
    public void addAttribute(final Object o) {

    }

    public Map<String, Object> getModelMap() {
        return vetMap;
    }
}
