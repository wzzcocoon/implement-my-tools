package cn.wzz;

import cn.wzz.interview2021.spring.A;
import cn.wzz.interview2021.spring.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UplodingPicApplicationTests {

	@Resource
	private CalcService calcService;

	@Test
	public void testAop() {

		System.out.println("Spring版本：" + SpringVersion.getVersion());
		System.out.println("SpringBoot版本：" + SpringBootVersion.getVersion());

		calcService.div(10,2);
	}

	@Autowired
	private A a;
	@Test
	public void testSpring() {
		/**		三级缓存解决循环依赖
		 * 1 调用doGetBean()方法，想要获取beanA，于是调用getSingleton()方法从缓存中查找beanA
		 * 2 在getSingleton()方法中，从一级缓存中查找，没有，返回null
		 * 3 doGetBean()方法中获取到的beanA为null，于是走对应的处理逻辑，调用getSingleton()的重载方法（参数为ObjectFactory的)
		 * 4 在getSingleton()方法中，先将beanA_name添加到一个集合中，用于标记该bean正在创建中。然后回调匿名内部类的creatBean方法
		 * 5 进入AbstractAutowireCapableBeanFactory#doCreateBean，先反射调用构造器创建出beanA的实例，然后判断。是否为单例、是否允许提前暴露引用(对于单例一般为true)、是否正在创建中〈即是否在第四步的集合中)。判断为true则将beanA添加到【三级缓存】中
		 * 6 对beanA进行属性填充，此时检测到beanA依赖于beanB，于是开始查找beanB
		 * 7 调用doGetBean()方法，和上面beanA的过程一样，到缓存中查找beanB，没有则创建，然后给beanB填充属性
		 * 8 此时beanB依赖于beanA，调用getsingleton()获取beanA，依次从一级、二级、三级缓存中找，此时从三级缓存中获取到beanA的创建工厂，通过创建工厂获取到singletonObject，此时这个singletonObject指向的就是上面在doCreateBean()方法中实例化的beanA
		 * 9 这样beanB就获取到了beanA的依赖，于是beanB顺利完成实例化，并将beanA从三级缓存移动到二级缓存中
		 * 10 随后beanA继续他的属性填充工作，此时也获取到了beanB，beanA也随之完成了创建，回到getsingleton()方法中继续向下执行，将beanA从二级缓存移动到一级缓存中
		 */
		System.out.println(a);
	}

}
