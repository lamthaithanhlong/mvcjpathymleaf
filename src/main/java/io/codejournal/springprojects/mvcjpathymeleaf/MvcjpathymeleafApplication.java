package io.codejournal.springprojects.mvcjpathymeleaf;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Account;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Appointment;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Patient;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.AppointmentRepository;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@SpringBootApplication
public class MvcjpathymeleafApplication {
	@Autowired
	private final AppointmentRepository appointmentRepository;

	@Autowired
	private final PatientRepository patientRepository;

	@Autowired
	private final AccountRepository accountRepository;

	public MvcjpathymeleafApplication(AppointmentRepository appointmentRepository, PatientRepository patientRepository, AccountRepository accountRepository) {
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcjpathymeleafApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeStudents() {
		return args -> {
			//Add Account
			Account account1 = new Account();
			account1.setAccountId(2L);
			account1.setAccountNumber("SV1104");
			account1.setCustomerName("AgroFeeds Corporation");
			account1.setAccountType("Savings");
			account1.setBalance("197,750.00");
			account1.setLastTransactionDate(LocalDate.parse("2023-05-21"));
			account1.setLastTransactionTime(LocalTime.of(10,05,00));


			//Add Account
			Account account2 = new Account();
			account2.setAccountId(3L);
			account2.setAccountNumber("SV2307");
			account2.setCustomerName("DeLawro and Co., LLC");
			account2.setAccountType("Savings");
			account2.setBalance("842,000.75");
			account2.setLastTransactionDate(LocalDate.parse("2023-05-20"));
			account2.setLastTransactionTime(LocalTime.of(07,00,00));

			//Add Account
			Account account3 = new Account();
			account3.setAccountId(4L);
			account3.setAccountNumber("CK4133");
			account3.setCustomerName("Bolingo Ventures");
			account3.setAccountType("Checking");
			account3.setBalance("74,500.00");
			account3.setLastTransactionDate(LocalDate.parse("2022-11-16"));
			account3.setLastTransactionTime(LocalTime.of(07,00,00));


			//Add Account
			Account account4 = new Account();
			account4.setAccountId(1L);
			account4.setAccountNumber("CK1089");
			account4.setCustomerName("United Metals Inc.");
			account4.setAccountType("Checking");
			account4.setBalance("105,945.50");
			account4.setLastTransactionDate(LocalDate.parse("2023-06-13"));
			account4.setLastTransactionTime(LocalTime.of(10,05,00));

			//Save Account
			accountRepository.saveAll(Arrays.asList(account1, account2, account3, account4));
		};
	}
}
