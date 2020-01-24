package com.junu.book.web.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class HelloControllerTest(private val mockMvc: MockMvc) {

    @ParameterizedTest
    @MethodSource("providerParams")
    @DisplayName("GET /hello 는 받아온 name, amount를 리턴한다.")
    fun testHello(name: String, amount: Int) {
        mockMvc.get("/hello"){
            param("name", name)
            param("amount", amount.toString())
        }
                .andDo { print() }
                .andExpect {
                    status { isOk }
                    jsonPath("$.name"){value(name)}
                    jsonPath("$.amount"){value(amount)}
                }
    }

    companion object {
        @JvmStatic
        fun providerParams() = listOf(
                Arguments.of("hi", 2000),
                Arguments.of("hello", 10000),
                Arguments.of("who", 20000),
                Arguments.of("you", 15000)
        )
    }

}