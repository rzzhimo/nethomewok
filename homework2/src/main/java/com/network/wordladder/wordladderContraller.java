package com.network.wordladder;


import com.network.wordladder.WordLadder;
import org.apache.catalina.connector.Response;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class wordladderContraller {

//    @RequestMapping("/word")
//    @ResponseBody
//    public Map<String,String> index(){
//        WordLadder word = new WordLadder();
//        String word1,word2;
//
//        String result = word.dfs("cat", "dog");
//        Map map=new HashMap<String,String>();
//        map.put("code","data");
//        map.put("cat","dog");
//        map.put("1",result);
//        return map;
//    }
    @RequestMapping(value = "/ladder", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ladder(@RequestParam("start") String start, @RequestParam("end") String end) throws IOException
    {
        WordLadder word = new WordLadder();
        String result = word.dfs(start, end);
        System.out.println(result);
        return result;
    }

}
