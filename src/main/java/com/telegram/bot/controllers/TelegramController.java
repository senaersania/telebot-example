package com.telegram.bot.controllers;

import com.telegram.bot.models.Telegram;
import com.telegram.bot.service.TeleBotChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TelegramController {
    @Autowired
    TeleBotChannelService teleBotChannelService;

    /**
     * @desc Action get index default page
     *
     * stack used : spring boot 2.7.8 & JDK 8 & Thymeleaf templates view
     *
     * @return to view ../resources/templates/index.html
     */
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    /**
     * @desc Action get telegram form when send message to channel via bot
     * @param model
     * @return to view ../resources/templates/telegram/index.html
     */
    @GetMapping("/v1/telegram-form")
    public String telegramChannelForm(Model model) {
        model.addAttribute("telegram", new Telegram());
        return "telegram/index";
    }

    /**
     * @desc Action handle when submit telegram form and send message to channel via bot
     * @param telegram
     * @param model
     * @return to view ../resources/templates/telegram/result.html
     */
    @PostMapping("/v1/telegram-submit")
    public String telegramChannelSubmit(@ModelAttribute Telegram telegram, Model model) {
        model.addAttribute("telegram", telegram);
        try {
            teleBotChannelService.sendChannelMessage(telegram.getContent());
        } catch (Exception exception){
            exception.getMessage();
        }
        return "telegram/result";
    }

    /**
     * @desc Do by yourself create another telegram form endpoint when send message to group via bot
     * @param model
     * @return
     */
    @GetMapping("/v2/telegram-form")
    public String telegramGroupForm(Model model) {
        return "telegram/index";
    }

    /**
     * @desc Do by yourself create handle submit telegram form endpoint and send message to group via bot
     * @param telegram
     * @param model
     * @return
     */
    @PostMapping("/v2/telegram-submit")
    public String telegramGroupSubmit(@ModelAttribute Telegram telegram, Model model) {
        model.addAttribute("telegram", telegram);
        try {
            // code to do here
        } catch (Exception exception){
            // code to do here
        }
        return "telegram/result";
    }
}
