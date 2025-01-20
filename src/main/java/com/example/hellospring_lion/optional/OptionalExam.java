package com.example.hellospring_lion.optional;

import java.util.Optional;

public class OptionalExam {
    public static void main(String[] args) {
        String msg = null;

        if(msg!=null){
            System.out.println(msg.charAt(0));
        }

        Optional<String> optional = Optional.empty();
        //값이 존재하는지 확인해서 처리하는 메서드
        if(optional.isPresent()){
            System.out.println(optional.get());
        }

        if(optional.isEmpty()){
            System.out.println("값이 없다면 처리할 부분 구현 ");
            System.out.println(optional.orElse("hi"));
        }




    }
}
