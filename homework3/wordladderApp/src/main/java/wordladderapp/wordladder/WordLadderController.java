package wordladderapp.wordladder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("*")
@Controller
@RequestMapping("/wordladder")
public class WordLadderController {
    static private boolean logged = false;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/ladder")
    public @ResponseBody
    String greeting(
            @RequestParam(value="start") String start,
            @RequestParam(value="end") String end) {
        if(logged) {

            WordLadder word = new WordLadder();
            String result = word.dfs(start, end);
            System.out.println(result);
            return result;

        }
        else
            return "未登录请先登录";
    }

    @RequestMapping("/login")
    public @ResponseBody boolean login(
            @RequestParam(value = "username") String name,
            @RequestParam(value = "password") String pwd) {
        String url = "http://checkhost:8088/check?username="+name+"&password="+pwd;//这里不能写localhost，会禁止访问
        RestTemplate restTemplate= new RestTemplate();
        Boolean res =restTemplate.getForObject(url,Boolean.class);
        if(res)
        {
            logged= true;
            return true;
        }
        else
            return false;
    }
}
