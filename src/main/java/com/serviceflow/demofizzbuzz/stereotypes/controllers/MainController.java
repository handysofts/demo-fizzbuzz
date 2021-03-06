package com.serviceflow.demofizzbuzz.stereotypes.controllers;

import com.serviceflow.demofizzbuzz.audit.Audit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by Vasif Mustafayev on 09.09.2017.
 * vmustafayev@gmail.com
 */
@Controller
public class MainController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    private final MessageSource messageSource;

    @Autowired
    public MainController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }




    /**
     * Index Page
     *
     * @param m
     * @return
     */
    @RequestMapping("/")
    public String index(Model m){
        m.addAttribute(CONTENT_FRAGMENT_FILE_NAME, "home");
        return PAGE_NAME_INDEX;
    }


    /**
     * Open pages in index
     *
     * @param m
     * @param pageName
     * @return
     */
    @RequestMapping("/pages/{pageName}")
    @Audit
    public String pages(Model m, @PathVariable String pageName, @RequestHeader HttpHeaders headers){
        if (logger.isDebugEnabled())
            for(String headerKey:headers.keySet())
                logger.debug("Header {}={}", headerKey, headers.get(headerKey));

        Locale locale = LocaleContextHolder.getLocale();
        m.addAttribute(CONTENT_FRAGMENT_FILE_NAME, pageName);
        m.addAttribute(PAGE_TITLE, messageSource.getMessage("page.title."+pageName, null, messageSource.getMessage("page.title.default", null, locale), locale));

        return PAGE_NAME_INDEX;
    }


}
