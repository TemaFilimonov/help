package course.controller;

import course.dao.UserDao;
import course.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Created by Артем Константинович on 30.09.2016.
 */
@RestController
@RequestMapping("/connect")

public class SocialController {

    private ConnectionRepository connectionRepository;

    @Autowired
    private UserDao userDao;


    @Inject
    public SocialController(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }


    @GetMapping("/facebook")
    @ResponseBody
    public ModelAndView facebook() {
        User user = new User();
        user.setName(connectionRepository.findPrimaryConnection(Facebook.class).getDisplayName());
        user.setUserType("facebook");
        userDao.create(user);
        return new ModelAndView("redirect:/" );
    }


    @GetMapping("/twitter")
    @ResponseBody
    public ModelAndView twitter() {
        User user = new User();
        user.setName(connectionRepository.findPrimaryConnection(Twitter.class).getDisplayName());
        user.setUserType("twitter");
        userDao.create(user);
        return new ModelAndView("redirect:/" );
    }

}
