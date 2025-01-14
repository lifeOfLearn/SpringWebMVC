package owner.exercise.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet.xml")
@WebAppConfiguration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnnotationControllerDemo1Test {
	
	@Autowired
	private AnnotationControllerDemo1 annControllerDemo;
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private WebApplicationContext wac;
	
	private String beanName = "annotationControllerDemo1";
	
	private Class<?> clazzName = AnnotationControllerDemo1.class;
	
	private String methodName = "index";
	
	@Test
	@Order(1)
	public void testBean() {
		System.out.println("start 測試加載Bean");
		assertNotNull(annControllerDemo, "沒有AnnotationControllerDemo1 的 bean");
		System.out.println("end 測試加載Bean");
	}
	
	@Test
	@Order(2)
	public void testBeanName() {
		System.out.println("start 測試Bean Name");
//		String[] beanNames = context.getBeanDefinitionNames();
//		boolean flag = false;
//		for (String beanName : beanNames) {
//			if (beanName.equals(this.beanName)) {
//				flag = true;
//				break;
//			}
//		}
//		assertTrue(flag, "Bean 名稱找不到");
		
		StringBuilder name = new StringBuilder();
		String[] nameByTypes = context.getBeanNamesForType(clazzName);
		for (String nameByType : nameByTypes) {
			name.append(nameByType);
		}
		assertEquals(this.beanName, name.toString(), "@Autowired加載的bean name : " + name.toString() + " != 設定的bean name : " + this.beanName);
		
		System.out.println("end 測試Bean Name");
	}
	
	@Test
	@Order(3)
	public void testMethod() {
		System.out.println("start 測試反射取得方法");
		
		String view = null;
		try {
			Method method = annControllerDemo.getClass().getMethod(this.methodName);
			view = (String) method.invoke(context.getBean(this.clazzName));
			
			assertNotNull(view, "取得modelAndView失敗");
			
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("反射取得方法失敗");
			e.printStackTrace();
		} catch (BeansException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e ) {
			System.out.println("反射invoke()失敗,無法取得ModelAndView");
			e.printStackTrace();
		}
		
		System.out.println("end 測試反射取得方法");
	}
	
	@Test
	@Order(4)
	public void testURL() {
		System.out.println("start 測試URL");
		
		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cindex"))
					//.content(...)
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(result ->{
						System.out.println("andDo start");
						ModelAndView modelAndView = result.getModelAndView();
						String viewName = modelAndView.getViewName();
						Map<String,Object> modelMap = modelAndView.getModel();
						System.out.println("viewName:" + viewName);
						System.out.println("modXelMap:");
						modelMap.forEach((key, value) -> System.out.println("key:" + key + ", value:" + value));
						System.out.println("andDo end");
					})
					.andReturn();
			//有問題沒顯示之後找
			System.out.println("result:" + mvcResult.getResponse().getContentAsString());
		} catch (Exception e) {
			System.out.println("err");
			e.printStackTrace();
		}				
			
		
		System.out.println("end 測試URL");
	}
}

