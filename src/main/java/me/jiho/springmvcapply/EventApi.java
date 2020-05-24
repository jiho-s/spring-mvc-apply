package me.jiho.springmvcapply;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    // 요청의 본문에 들어있는 데이터를 이벤트로 Conversion -> HttpMessageConverter가 수행
    public Event createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //Custom으로 바인딩 에러를 처리하고 싶은경우
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error);
            });
        }
        //... save Event
        return event;
    }
}
