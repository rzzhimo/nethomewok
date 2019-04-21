package com.network.wordladder.wordController;


import com.network.wordladder.wordladder.WordLadder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class WordladderController {


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
