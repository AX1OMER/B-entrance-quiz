package com.thoughtworks.capability.gtb.entrancequiz.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
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

    List<List<String>> groupedStudents = new ArrayList<List<String>>();

    @GetMapping("/student/list")
    public ResponseEntity<List<String>> getStudentList() {
        List<String> indexedStudents = getIndexedStudentList();
        return ResponseEntity.ok(indexedStudents);
    }

    @GetMapping("/student/group")
    public ResponseEntity<List<List<String>>> groupedStudentList() {
        groupedStudents.clear();
        int groupNumber = 6;
        int totalNumber = students.size();
        int groupSize[] = new int[groupNumber];
        for (int groupIndex = 0; groupIndex < groupNumber; groupIndex++) {
            groupSize[groupIndex] = totalNumber / groupNumber;
        }
        for (int groupIndex = 0; groupIndex < totalNumber % groupNumber; groupIndex++) {
            groupSize[groupIndex] += 1;
        }
        List<String> shuffledStudents = new ArrayList<String>();
        List<String> indexedStudents = getIndexedStudentList();
        for (String student : indexedStudents) {
            shuffledStudents.add(student);
        }
        Collections.shuffle(shuffledStudents);
        int indexAll = -groupSize[0];
        for (int groupIndex = 0; groupIndex < groupNumber; groupIndex++) {
            List<String> groupStudents = new ArrayList<String>();
            groupStudents.add((groupIndex + 1) + " 组");
            indexAll += groupSize[groupIndex];
            for (int index = 0; index < groupSize[groupIndex]; index++) {
                groupStudents.add(shuffledStudents.get(indexAll + index));
            }
            groupedStudents.add(groupStudents);
        }
        return ResponseEntity.ok(groupedStudents);
    }

    @PostMapping("/student")
    public ResponseEntity<List<String>> addStudent(@RequestBody String student) {
        students.add(student);
        return getStudentList();
    }

    private List<String> getIndexedStudentList() {
        List<String> studentsWithIndex = new ArrayList<String>();
        for (int index = 0; index < students.size(); index++) {
            studentsWithIndex.add((index + 1) + ". " + students.get(index));
        }
        return studentsWithIndex;
    }
}
