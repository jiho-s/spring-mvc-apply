package me.jiho.springmvcapply;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {
    interface ValidateID {}
    interface ValidateName {}

    @Min(value = 0, groups = ValidateID.class)
    private Integer id;

    @NotBlank(groups = ValidateName.class)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
