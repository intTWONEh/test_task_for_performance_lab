package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Task3
{
    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.out.println("You need to specify data files!");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode nodesTest =  mapper.readTree(Paths.get(args[0]).toFile());
        JsonNode nodesValues = mapper.readTree(Paths.get(args[1]).toFile());

        Map<Integer, String> values = new HashMap<>();
        nodesValues.path("values").forEach( node ->
                   values.put(node.findValue("id").asInt(), node.findValue("value").asText())
        );

        nodesTest.get("tests").findParents("id").forEach(
                node -> {
                    String value = values.get(node.findValue("id").asInt());
                    if(value != null) ((ObjectNode) node).put("value",  value);
                }
        );

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("result.json"), nodesTest);
    }
}
