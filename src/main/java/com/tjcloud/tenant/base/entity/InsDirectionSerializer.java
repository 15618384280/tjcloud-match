package com.tjcloud.tenant.base.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InsDirectionSerializer extends JsonSerializer<Integer> {

    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        int level = value;
        // 0-三级指导员,1-二级指导员,2-一级指导员,3-国家级指导员,4-预备指导员
        Optional.of(value).ifPresent(v -> {
            InsDirection insDirection = InsDirection.fromOrdinal(v);
            Map<String, Object> map = new HashMap<>();
            map.put("direction", value);
            map.put("name", insDirection.name());
            try {
                gen.writeObject(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
