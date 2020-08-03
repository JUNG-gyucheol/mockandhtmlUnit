package com.example.springboot11;

import ch.qos.logback.core.util.ContentTypeUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.Html;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
//     mockmvc를 이용한 테스트
//    @Autowired
//    MockMvc mockMvc;

    //htmlunit을 이용한테스트
    @Autowired
    WebClient webClient;
    @Test
    public void hello() throws Exception {
        //요청 "/"
        //응답
        //-모델 name : keesun
        // -뷰 이름 : hello

//        mockMvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().string(containsString("keesun")))
//                .andExpect(view().name("hello"))
//                .andExpect(model().attribute("name",is("keesun")));

        HtmlPage page = webClient.getPage("/hello");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("keesun");
    }
}