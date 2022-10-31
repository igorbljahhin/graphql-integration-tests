package com.example.graphqlintegrationtests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.graphql.test.tester.WebGraphQlTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GraphqlIntegrationTestsApplicationTests {
    @Autowired
    private WebApplicationContext context;
    private WebGraphQlTester tester;

    @BeforeEach
    public void before() {
        WebTestClient webTestClient = MockMvcWebTestClient.bindToApplicationContext(context)
                .configureClient()
                .baseUrl("/graphql")
                .build();
        tester = HttpGraphQlTester.create(webTestClient);
    }

    @Test
    public void testGetRegistrationMethods() {
        String document = """
                query {
                  registrationMethods {
                    method
                  }
                }""";

        tester.document(document)
                .execute()
                .path("data.registrationMethods[*].method")
                .entityList(String.class)
                .hasSize(4)
                .containsExactly("MAGIC_LINK", "USERNAME", "GOOGLE", "FACEBOOK");
    }
}
