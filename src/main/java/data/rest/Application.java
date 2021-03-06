package data.rest;

import data.rest.member.Member;
import data.rest.member.MemberRepository;
import data.rest.todo.Todo;
import data.rest.todo.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner commandLineRunner(MemberRepository memberRepository, TodoRepository todoRepository) {
		return args -> {
			Member woniper = memberRepository.findByUsername("woniper");
			todoRepository.save(new Todo(woniper, "spring camp에서 발표하기"));
			todoRepository.save(new Todo(woniper, LocalDate.now().plusDays(10), "slipp에서 발표하기"));
			todoRepository.save(new Todo(woniper, LocalDate.now().plusDays(14), "운동하기"));
			todoRepository.save(new Todo(woniper, LocalDate.now().plusDays(20), "책읽기"));
		};
	}
}
