package com.autentia.cursolgtm.externalEntitiesXXE;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mark")
public class MarkController {

    private Mark mark;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/xml"})
    public Mark getMarks() {
        return mark;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {"application/xml", "text/xml"})
    public void addMark(@RequestBody Mark mark) {
        this.mark = mark;
    }

}
