import com.marchi.demo.springmvc.config.MyMvcConfig;
import com.marchi.demo.springmvc.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")//注解在类上，用来声明加载的ApplicationContext是一个WebApplicationContext。他的属性指定的是Web资源的位置，默认为src/main/webapp
public class TestControllerIntegrationTests {
    //MockMvc-模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;

    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void testNormalController()throws Exception{
        mockMvc.perform(get("/normal")).//模拟像/normal进行get请求
                andExpect(status().isOk()).//预期控制返回状态为200
                andExpect(view().name("page")).//预期view的名称为page
                andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp")).//预期页面转向的真正路径为
                andExpect(model().attribute("msg",demoService.saySomething()));//预期model的的值是hello
    }

    public void testRestController()throws Exception{
        mockMvc.perform(get("/testRest")).
                andExpect(status().isOk()).
                andExpect(content().contentType("text/plain;charset=UTF-8")).//预期某提类型
                andExpect(content().string(demoService.saySomething()));
    }

}
