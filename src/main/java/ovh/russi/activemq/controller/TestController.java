package ovh.russi.activemq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/getList/{variable}")
    public Map<String, Object> getList(@PathVariable String variable) {
        log.info(variable);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        map.put("name", variable);
        map.put("age", 21);
        map.put("surname", variable.concat("_").concat(variable));
        map1.put("name", variable.concat("_lupino"));
        map1.put("age", 38);
        map1.put("surname", variable.concat("_").concat(variable));
        map2.put("name", variable.concat("_cacchiuliddu"));
        map2.put("age", 46);
        map2.put("surname", variable.concat("_").concat(variable));
        Map<String, Object> finalMap = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        finalMap.put("customMap", list);
        return finalMap;
    }
}
