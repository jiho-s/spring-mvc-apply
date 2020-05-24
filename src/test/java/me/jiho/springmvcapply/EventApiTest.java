package me.jiho.springmvcapply;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EventApiTest {

    @Autowired
    ObjectMapper objectMapper;
    // 객체 -> JSON 문자열, JSON 문자열 -> 객체

    @Autowired
    MockMvc mockMvc;

    @Test
    public void creatEvnet() throws Exception {

        Event event = new Event();
        event.setName("jiho");
        event.setLimit(20);

        String json = objectMapper.writeValueAsString(event);
        //객체를 JSON 문자열로 변환


        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("name").value("jiho"))
                    .andExpect(jsonPath("limit").value("20"));

    }
}