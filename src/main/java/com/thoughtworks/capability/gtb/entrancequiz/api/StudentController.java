package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<String> students = new ArrayList<String>() {{
        add("成吉思汗");
        add("鲁班七号");
        add("太乙真人");
        add("钟无艳");
        add("花木兰");
        add("雅典娜");
        add("芈月");
        add("白起");
        add("刘禅");
        add("庄周");
        add("马超");
        add("刘备");
        add("哪吒");
        add("大乔");
        add("蔡文姬");
    }};

    @GetMapping("/student/list")
    public ResponseEntity<List<String>> getStudentList() {
        List<String> indexedStudents = getIndexedStudentList();
        return ResponseEntity.ok(indexedStudents);
    }

    private List<String> getIndexedStudentList() {
        List<String> studentsWithIndex = new ArrayList<String>();
        for (int index = 0; index < students.size(); index++) {
            studentsWithIndex.add((index + 1) + ". " + students.get(index));
        }
        return studentsWithIndex;
    }
}
