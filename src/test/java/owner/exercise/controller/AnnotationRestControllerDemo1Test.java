package owner.exercise.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.ModelAndView;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet.xml")
public class AnnotationRestControllerDemo1Test {
	
	@Autowired
	private AnnotationRestControllerDemo1 annControllerDemo;
	
	@Autowired
	private ApplicationContext context;
	
	private String beanName = "annotationRestControllerDemo1";
	
	private Class<?> clazzName = AnnotationRestControllerDemo1.class;
	
	private String methodName = "index";
	
	@Test
	public void testBean() {
		System.out.println("start 測試加載Bean");
		assertNotNull(annControllerDemo, "沒有AnnotationControllerDemo1 的 bean");
		System.out.println("end 測試加載Bean");
	}
	
	@Test
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
		String[] nameByTypes = context.getBeanNamesForType(this.clazzName);
		for (String nameByType : nameByTypes) {
			name.append(nameByType);
		}
		assertEquals(this.beanName, name.toString(), "@Autowired加載的bean name : " + name.toString() + " != 設定的bean name : " + this.beanName);
		
		System.out.println("end 測試Bean Name");
	}
	
	@Test
	public void testMethod() {
		System.out.println("start 測試反射取得方法");
		
		ModelAndView modelAndView = null;
		try {
			Method method = annControllerDemo.getClass().getMethod(this.methodName);
			modelAndView = (ModelAndView) method.invoke(context.getBean(this.clazzName));
			
			assertNotNull(modelAndView, "取得modelAndView失敗");
			
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("反射取得方法失敗");
			e.printStackTrace();
		} catch (BeansException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e ) {
			System.out.println("反射invoke()失敗,無法取得ModelAndView");
			e.printStackTrace();
		}
		
		System.out.println("end 測試反射取得方法");
	}
}
