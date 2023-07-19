package com.cjj;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 嵌套情况下，外部不会驱动内部的before（after）each/all之类的方法，
 * 但是内部嵌套可以驱动外部的方法
 *
 */
@DisplayName("嵌套测试")
public class TestingAStackDemo {
        static Stream<String> stringStream(){
            return Stream.of("java","c++");
        }
        @DisplayName("参数化测试")
        @ParameterizedTest
        @ValueSource(ints  = {1,2,3,4,5})
        void parameterizedTest1(int i){
            System.out.println(i);
        }

        @DisplayName("方式参数化测试")
        @ParameterizedTest
        @MethodSource("stringStream")
        void parameterizedTest2(String i){
            System.out.println(i);
         }

        Stack<Object> stack;

        @Test
        @DisplayName("is instantiated with new Stack()")
        void isInstantiatedWithNew() {
            new Stack<>();
        }

        @Nested//嵌套类
        @DisplayName("when new")
        class WhenNew {

            @BeforeEach
            void createNewStack() {
                stack = new Stack<>();
            }

            @Test
            @DisplayName("is empty")
            void isEmpty() {
                Assertions.assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("throws EmptyStackException when popped")
            void throwsExceptionWhenPopped() {
                Assertions.assertThrows(EmptyStackException.class, stack::pop);
            }

            @Test
            @DisplayName("throws EmptyStackException when peeked")
            void throwsExceptionWhenPeeked() {
                Assertions.assertThrows(EmptyStackException.class, stack::peek);
            }

            @Nested
            @DisplayName("after pushing an element")
            class AfterPushing {

                String anElement = "an element";

                @BeforeEach
                void pushAnElement() {
                    stack.push(anElement);
                }

                @Test
                @DisplayName("it is no longer empty")
                void isNotEmpty() {
                    Assertions.assertFalse(stack.isEmpty());
                }

                @Test
                @DisplayName("returns the element when popped and is empty")
                void returnElementWhenPopped() {
                    Assertions. assertEquals(anElement, stack.pop());
                    Assertions.  assertTrue(stack.isEmpty());
                }

                @Test
                @DisplayName("returns the element when peeked but remains not empty")
                void returnElementWhenPeeked() {
                    Assertions. assertEquals(anElement, stack.peek());
                    Assertions.  assertFalse(stack.isEmpty());
                }
            }
        }
    }
