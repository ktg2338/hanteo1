package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

class CategoryTree {
    private final Map<Integer, CategoryNode> nodes = new HashMap<>();
    private final Map<String, List<CategoryNode>> nameMap = new HashMap<>();
    //루트 후보들을 저장하는 Set
    //부모가 없는 노드들(parentId == -1)
    private final Set<Integer> rootCandidates = new HashSet<>();

    public void addCategory(int parentId, int childId, String name) {
        //childId에 해당하는 노드가 없으면 새로 만들고 name을 설정.
        CategoryNode childNode = nodes.computeIfAbsent(childId, id -> new CategoryNode(id, name));
        childNode.name = name;
        nameMap.computeIfAbsent(name, o -> new ArrayList<>()).add(childNode);

        if (parentId != -1) {
            CategoryNode parentNode = nodes.computeIfAbsent(parentId, id -> new CategoryNode(id, "unknown"));
            parentNode.children.add(childNode);
            rootCandidates.remove(childId);
        } else {
            rootCandidates.add(childId);
        }
    }

    public CategoryNode findById(int id) {
        return nodes.get(id);
    }

    public List<CategoryNode> findByName(String name) {
        return nameMap.getOrDefault(name, Collections.emptyList());
    }

    public String toJson(CategoryNode node) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
    }
}
