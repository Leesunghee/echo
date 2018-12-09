package com.ready2die.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("accounts")
public class AccountController {

    //<a href="/accounts/A001?format=standard">
    @RequestMapping("{accountId}")
    public String showAccount(@PathVariable String accountId, Model model) {
        //@PathVariable을 사용해 취득한 경로 변수의 값은 Model 객체에 같은 이름으로 저장된다.
        //accountId = "A001"
        return null;
    }

    @RequestMapping(path = "detail", method = RequestMethod.GET)
    public String detail(@RequestParam String format) {
        //format = "standard"
        return null;
    }

    @RequestMapping(path = "create", params = "form")
    public String form(Model model) {
        model.addAttribute(new AccountCreateForm());
        return "account/form";
    }

    @RequestMapping(path = "create", method = RequestMethod.POST, params = "confirm")
    public String confirm(@Validated AccountCreateForm form, BindingResult result) {

        return "account/confirm";
    }

    @RequestMapping(path = "create", method = RequestMethod.POST, params = "redo")
    public String redo(AccountCreateForm form) {

        return "account/form";
    }

    @RequestMapping(path = "create", method = RequestMethod.POST, params = "create")
    public String create(@Validated AccountCreateForm form, BindingResult result, RedirectAttributes redirectAttributes) {

        return "redirect:/accounts/create?complete";
    }

    @RequestMapping(path = "create", method = RequestMethod.GET, params = "complate")
    public String complete() {
        return "account/complete";
    }



}
