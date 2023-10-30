package com.example.demo;

import com.example.demo.domain.DemoItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

@SpringBootApplication
public class SpringDataProjectionDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataProjectionDemo1Application.class, args);
	}

	@Bean
	public DefaultConversionService conversionService() {
		return new DefaultConversionService();
	}

	@EventListener
	public void handleBeforeSaveEvent(BeforeSaveEvent<?> event) {
		Class<?> entityClass = event.getEntity().getClass();
		if (entityClass.equals(DemoItem.class)) {
			DemoItem orderItem = (DemoItem) event.getEntity();
			if (orderItem.getId() == null) {
				orderItem.setId(4);
			}
		}
	}
}
