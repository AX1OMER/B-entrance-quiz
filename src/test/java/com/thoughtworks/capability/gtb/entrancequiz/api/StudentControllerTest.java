package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldGetStudentList() throws Exception {
        mockMvc.perform(get("/student/list"))
                .andExpect(jsonPath("$[0]", is("1. 成吉思汗")))
                .andExpect(jsonPath("$[1]", is("2. 鲁班七号")))
                .andExpect(jsonPath("$[2]", is("3. 太乙真人")))
                .andExpect(jsonPath("$[3]", is("4. 钟无艳")))
                .andExpect(jsonPath("$[4]", is("5. 花木兰")))
                .andExpect(jsonPath("$[5]", is("6. 雅典娜")))
                .andExpect(jsonPath("$[6]", is("7. 芈月")))
                .andExpect(jsonPath("$[7]", is("8. 白起")))
                .andExpect(jsonPath("$[8]", is("9. 刘禅")))
                .andExpect(jsonPath("$[9]", is("10. 庄周")))
                .andExpect(jsonPath("$[10]", is("11. 马超")))
                .andExpect(jsonPath("$[11]", is("12. 刘备")))
                .andExpect(jsonPath("$[12]", is("13. 哪吒")))
                .andExpect(jsonPath("$[13]", is("14. 大乔")))
                .andExpect(jsonPath("$[14]", is("15. 蔡文姬")))
                .andExpect(status().isOk());
    }

    @Test
    void shouldShuffleStudents() throws Exception {
        mockMvc.perform(get("/student/group"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldAddStudent() throws Exception {
        String newStudent = "测试学生";
        mockMvc.perform(post("/student").content(newStudent).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/student/list"))
                .andExpect(jsonPath("$[15]", is("16. 测试学生")))
                .andExpect(status().isOk());
    }
}
