package com.example.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * 시작점 (Entry Point)
 *
 * @SpringBootApplication :
 * - 내부적으로 @Configuration, @EnableAutoConfiguration, @ComponentScan 포함
 * - @Configuration        : 설정 클래스로서 Bean 등록 가능
 * - @ComponentScan        : 현재 패키지와 하위 패키지에서 컴포넌트(@Component, @Service 등)를 자동 탐색
 * - @EnableAutoConfiguration : 클래스패스 설정 등을 기반으로 자동 설정 적용
 *
 * → 설정 클래스 + 컴포넌트 스캔 + 자동 설정을 한번에 처리하는 애너테이션
 *
 * SpringApplication.run(...) :
 * - 내장 톰캣을 포함한 스프링 애플리케이션 실행
 */

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}