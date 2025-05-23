package com.example.demo.stream;

import com.example.demo.stream.dto.UserDTO;
import com.example.demo.stream.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        t4();
    }

    public static void t1() {
        // # map, collect (기초 변환) : 전부 소문자로 바꿔서 새로운 리스트 만들기
        List<String> names = List.of("ALICE", "BOB", "CHARLIE");
        List<String> result = names.stream().map(name -> name.toLowerCase()).toList();
        System.out.println(result);
    }

    public static void t2() {
        // # filter 조건걸기 : 30보다 큰 수만 필터링해서 리스트로 만들기
        List<Integer> numbers = List.of(10, 25, 30, 45, 50, 65);
        List<Integer> result = numbers.stream().filter(number -> number > 30).toList();
        System.out.println(result);

    }

    public static void t3() {
        // # map + filter + collect (혼합 응용) : 이름 길이가 6자 이상인 도시들만 전부 대문자로 바꿔서 리스트 만들기
        List<String> cities = List.of("seoul", "busan", "incheon", "daejeon");
        List<String> result = cities.stream().filter(city -> city.length() > 6).map(String::toUpperCase).toList();
        System.out.println(result);
    }

    public static void t4() {
        // # DTO 변환 : User 리스트를 UserDTO 리스트로 변환하되,
        //이름이 28살 이상인 사람만 추려서 UserDTO(name)로 만들기
        List<User> userList = List.of(
                new User("Jin", 25),
                new User("Mina", 30),
                new User("Taehyung", 28)
        );

        List<UserDTO> result = userList.stream().filter(u -> u.getAge() > 28)
                .map(u -> new UserDTO(u.getName())).toList();
        System.out.println(result);
    }
    public static void t5() {
        // # 숫자 집계 : 점수 평균 구하기 (평균 타입은 double)
        List<Integer> scores = List.of(70, 85, 90, 95, 60);

        double result = scores.stream().mapToInt(score -> score).average().orElse(0.0);
        System.out.println(result);
    }
}
