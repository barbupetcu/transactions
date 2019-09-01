package com.transactions.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ValidationApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenTransactionDetailsAreEmpty() throws Exception {
		String transaction = "{\n" +
				"\t\"payer\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389748\",\n" +
				"\t\t\"cnp\":\"2950122150046\",\n" +
				"\t\t\"name\":\"test\"\n" +
				"\t},\n" +
				"\t\n" +
				"\t\"payee\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389748\",\n" +
				"\t\t\"cnp\":\"1850512025795\",\n" +
				"\t\t\"name\":\"test\"\n" +
				"\t}\n" +
				"\t\n" +
				"}";

		mockMvc.perform(post("/createTransaction")
				.content(transaction)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.timestamp", is(notNullValue())))
				.andExpect(jsonPath("$.errors.amount", is("Suma este obligatorie")))
				.andExpect(jsonPath("$.errors.description", is("Descrierea este obligatorie")))
				.andExpect(jsonPath("$.errors.type", is("Tipul tranzactiei nu este valid")))
				.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void whenPayerIbanIsEmptyForIBAN_TO_IBAN() throws Exception {
		String transaction = "{\n" +
				"\t\"payer\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"\",\n" +
				"\t\t\"cnp\":\"2950122150046\",\n" +
				"\t\t\"name\":\"test\"\n" +
				"\t},\n" +
				"\t\n" +
				"\t\"type\":\"IBAN_TO_IBAN\",\n" +
				"\t\"description\":\"test\",\n" +
				"\t\"amount\":\"55\",\n" +
				"\t\"payee\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389748\",\n" +
				"\t\t\"cnp\":\"1850512025795\",\n" +
				"\t\t\"name\":\"test\"\n" +
				"\t}\n" +
				"\t\n" +
				"\t\n" +
				"}";

		mockMvc.perform(post("/createTransaction")
				.content(transaction)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.timestamp", is(notNullValue())))
				.andExpect(jsonPath("$.errors.['payer.iban']", is("Campul este obligatoriu")))
				.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void whenPayeeIbanAndCnpAreInvalidForWALLET_TO_IBAN() throws Exception {
		String transaction = "{\n" +
				"\t\"payer\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389748\",\n" +
				"\t\t\"cnp\":\"2950122150046\",\n" +
				"\t\t\"name\":\"test\"\n" +
				"\t},\n" +
				"\t\n" +
				"\t\"type\":\"IBAN_TO_IBAN\",\n" +
				"\t\"description\":\"test\",\n" +
				"\t\"amount\":\"55\",\n" +
				"\t\"payee\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389722\",\n" +
				"\t\t\"cnp\":\"1850512022222\",\n" +
				"\t\t\"name\":\"test\"\n" +
				"\t}\n" +
				"\t\n" +
				"\t\n" +
				"}";

		mockMvc.perform(post("/createTransaction")
				.content(transaction)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.timestamp", is(notNullValue())))
				.andExpect(jsonPath("$.errors.['payee.iban']", is("Ibanul nu este valid")))
				.andExpect(jsonPath("$.errors.['payee.cnp']", is("CNP-ul nu este valid")))
				.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void validTransaction() throws Exception {
		String transaction = "{\n" +
				"\t\"payer\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389748\",\n" +
				"\t\t\"cnp\":\"2950122150046\",\n" +
				"\t\t\"name\":\"Alexandra P\"\n" +
				"\t},\n" +
				"\t\n" +
				"\t\"type\":\"IBAN_TO_IBAN\",\n" +
				"\t\"description\":\"test\",\n" +
				"\t\"amount\":\"55\",\n" +
				"\t\"payee\":\n" +
				"\t{\n" +
				"\t\t\"iban\":\"RO49INGB0000999901389748\",\n" +
				"\t\t\"cnp\":\"1850512025795\",\n" +
				"\t\t\"name\":\"Petcu B\"\n" +
				"\t}\n" +
				"}";

		mockMvc.perform(post("/createTransaction")
				.content(transaction)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.timestamp", is(notNullValue())))
				.andExpect(jsonPath("$.message", is("Solicitarea a fost inregistrata")))
				.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON_UTF8));
	}
}

