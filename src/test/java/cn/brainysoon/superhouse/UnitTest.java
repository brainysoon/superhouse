package cn.brainysoon.superhouse;

import cn.brainysoon.superhouse.web.IndexController;
import cn.brainysoon.superhouse.web.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by brainy on 17-2-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
public class UnitTest {

    /**
     * 首页单元测试
     */
    @Test
    public void testIndex() throws Exception {

        IndexController indexController = new IndexController();

        MockMvc mockMvc = standaloneSetup(indexController).build();

        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }
}
