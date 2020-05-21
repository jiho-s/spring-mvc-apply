package me.jiho.springmvcapply;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String evnetsForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/form";
    }

    @PostMapping("/events")
    public String events(@Validated @ModelAttribute Event event,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "events/form";
        }


        //.. 데이터 베이스에 저장
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {
        //... 데이터 베이스에서 리스트를 읽어옴
        model.addAttribute(eventList);
        return "/events/list"
    }
}
