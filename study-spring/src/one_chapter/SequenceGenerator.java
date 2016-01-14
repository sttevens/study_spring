package one_chapter;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SequenceGenerator {
	private String prefix;
	private String suffix;
	private int initial;
	private int counter;
	public SequenceGenerator(){
		
	}
	public SequenceGenerator(String prefix,String suffix,int initial){
		this.prefix = prefix;
		this.suffix = suffix;
		this.initial = initial;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public void setInitial(int initial) {
		this.initial = initial;
	}
	
	public synchronized String getSequence(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefix);
		buffer.append(initial+counter++);
		buffer.append(suffix);
		return buffer.toString();
	}
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("one_chapter/beans.xml");
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("one_chapter/beans.xml"));
		SequenceGenerator s = (SequenceGenerator) bf.getBean("sequenceGenerator");
		System.out.println(s.getSequence());
		System.out.println(s.getSequence());
	}
}
