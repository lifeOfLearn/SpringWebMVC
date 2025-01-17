package owner.exercise.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import owner.exercise.aop.HelloAOP;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class AspectThisAndTargetTest {
	
	@Autowired
	private HelloAOP helloAOP;
	
	@Test
	public void test() {
		System.out.println(helloAOP);
//		E e = new E();
//		e.tt();
//		helloAOP.new F();
//		helloAOP.new G();
//		helloAOP.new H();
//		helloAOP.new I();
//		helloAOP.new J();
//		helloAOP.new K();
//		helloAOP.new L();
//		helloAOP.new M();
	}
}

