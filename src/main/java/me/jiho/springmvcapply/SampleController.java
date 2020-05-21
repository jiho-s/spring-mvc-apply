package me.jiho.springmvcapply;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.PushBuilder;
import java.util.Map;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String evnetsForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/form";
    }

    @PostMapping("/events")
    @ResponseBody
    public Event events(@RequestParam String name,
                        @RequestParam Integer id) {
        Event event = new Event();
        event.setName(name);
        event.setId(id);
        return event;
    }
}
