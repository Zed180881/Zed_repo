package sia.spitter.spitterweb;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import sia.spitter.spitterdomainjpa.Spitter;

@Controller
@RequestMapping(value = "/things")
public class ThingController {
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public
    @ResponseBody
    Spitter createThing(@RequestBody Spitter spitter, HttpServletResponse response) {
        System.out.println("GOT A SPITTER:  " + spitter.getUsername());
        response.setHeader("Location", "http://www.habuma.com/foo/bar");
        return spitter;
    }
}
