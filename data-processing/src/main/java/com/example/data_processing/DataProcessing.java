package com.example.data_processing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class DataProcessing {
    
    /*
     * model : 뷰 데이터를 전달할 때 사용
     *  - @ResponseBody 사용 x
     */
    @GetMapping("/model")
    String model(Model model) {
        model.addAttribute("name", "남재상");
        return "model.html";
    }


    /*
     * List<타입> : 리스트 자료형
     *  - Object : 아무 타입 다 들어갈 수 있음
     *  - String / Integer / Entity / DTO
     *  - ArrayList LinkedList 등이 있는데 걍 List 쓰면됨
     */
    @GetMapping("/list")
    @ResponseBody
    public List<String> List () {
        List<String> list = new ArrayList<>();
        list.add("Strong");
        list.add("JaeSang");
        System.out.println(list.get(0));
        return list;
    }



    /*
     * Map<key, value> : Map 자료형
     *  - HashMap, LinkedHashMap, TreeMap 등의 상위요소
     *  - 그냥 Map 쓰면 됨
     */
    @GetMapping("/map")
    @ResponseBody
    public Map<String, Object> Map () {
        Map<String, Object> result = new HashMap<>();
        result.put("희망기업", "네이버");

        Map<String, Object> response = new HashMap<>();
        response.put("response", result);
        return response;
    }



    /*
     * Optional<타입> : 값이 있을 수도있고 없을수도 있는 자료형
     *  - isPresent() : 값이 있으면 True
     *  - isEmpty() : 값이 없으면 True
     */
//    @GetMapping("/optional")
//    @ResponseBody
//    public Optional<String> Optional () {
//        // 원래는 DB에서 데이터를 찾는 의도임
//        Optional<String> result = "strong_jaesang";
//
//        if (result.isPresent()) {
//            return "값이 있어요";
//        }
//
//        if (result.isEmpty()) {
//            return "값이 없어요";
//        }
//     }
}
