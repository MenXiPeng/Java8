package com.mxp.java8;

import java.util.Optional;

import com.mxp.model.Student;
import org.junit.Test;

/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):将map进行扁平化处理。
 */
public class TestOptional {
	
	@Test
	public void test4(){
		Optional<Student> op = Optional.of(new Student());

		System.out.println(op);

		Optional<String> op2 = op.map(Student::getName);
		System.out.println(op2.get());
//
		Optional<String> op3 = op.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(op3.get());
	}
	
	@Test
	public void test3(){
		Optional<Student> op = Optional.ofNullable(new Student());

		String s = op.map(u -> u.getName()).orElse("666");
		System.out.println(s);
//		System.out.println(op.isPresent());

//		if(op.isPresent()){
//			System.out.println(op.get());
//		}

//		Student emp = op.orElse(new Student(101, "张三", 18));
//		System.out.println(emp);
//
//		Student emp2 = op.orElseGet(() -> new Student());
//		System.out.println(emp2);
	}
	
	@Test
	public void test2(){
		/*Optional<Employee> op = Optional.ofNullable(null);
		System.out.println(op.get());*/
		
//		Optional<Employee> op = Optional.empty();
//		System.out.println(op.get());
	}

	@Test
	public void test1(){
		Optional<Student> op = Optional.of(new Student());
		Student emp = op.get();
		System.out.println(emp);
	}
	

}
