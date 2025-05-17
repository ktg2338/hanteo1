package org.example;


import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        CategoryTree tree = new CategoryTree();

        tree.addCategory(-1, 100, "남자");
        tree.addCategory(100, 101, "엑소");
        tree.addCategory(101, 1, "공지사항");
        tree.addCategory(101, 2, "첸");
        tree.addCategory(101, 3, "백현");
        tree.addCategory(101, 4, "시우민");

        tree.addCategory(100, 102, "방탄소년단");
        tree.addCategory(102, 5, "공지사항");
        tree.addCategory(102, 6, "익명게시판");
        tree.addCategory(102, 7, "뷔");

        tree.addCategory(-1, 200, "여자");
        tree.addCategory(200, 201, "블랙핑크");
        tree.addCategory(201, 8, "공지사항");
        tree.addCategory(201, 6, "익명게시판");
        tree.addCategory(201, 9, "로제");

        // 검색 및 출력
        List<CategoryNode> found = tree.findByName("여자");
        //이름이 같은 노드가 여러개 있을수 있으므로 루프문
        for (CategoryNode node : found) {
            System.out.println(tree.toJson(node));
        }

        // 식별자 검색
        CategoryNode byId = tree.findById(100);
        System.out.println(tree.toJson(byId));
    }
}